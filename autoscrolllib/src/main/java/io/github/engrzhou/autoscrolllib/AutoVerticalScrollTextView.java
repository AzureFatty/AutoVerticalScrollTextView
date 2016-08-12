package io.github.engrzhou.autoscrolllib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

/**
 * Function:
 * Created by BBTree Team
 * Author: EngrZhou
 * Create Date: 2016/08/11
 * Create Time: 上午10:00
 */
public class AutoVerticalScrollTextView extends TextView {
    private int delayStart = 5;//延迟滚动时间（单位秒）
    private boolean resetOnFinish = false;//滚动结束之后是否重置
    private int step = 5;//步进距离
    private int speed = 1;//速度=n*50ms
    private ScrollStatusListener mScrollStatusListener;//状态监听

    public AutoVerticalScrollTextView(Context context) {
        super(context);
        init(context, null);
    }

    public AutoVerticalScrollTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public AutoVerticalScrollTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }


    private MarqueeRunnable mMarqueeRunnable;

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            final TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.AutoVerticalScrollTextView, 0, 0);
            delayStart = array.getInt(R.styleable.AutoVerticalScrollTextView_delayStart, 5);
            resetOnFinish = array.getBoolean(R.styleable.AutoVerticalScrollTextView_resetOnFinish, false);
            step = array.getInt(R.styleable.AutoVerticalScrollTextView_step, 5);
            speed = array.getInt(R.styleable.AutoVerticalScrollTextView_speed, 1);
            array.recycle();
        }

    }

    /**
     * 获取延迟启动时间
     *
     * @return
     */
    public int getDelayStart() {
        return delayStart;
    }

    /**
     * 设置延迟启动时间
     *
     * @param delayStart
     */
    public void setDelayStart(int delayStart) {
        this.delayStart = delayStart;
    }

    /**
     * 滚动结束是否重置
     *
     * @return
     */
    public boolean isResetOnFinish() {
        return resetOnFinish;
    }

    /**
     * 设置滚动结束是否重置
     *
     * @param resetOnFinish
     */
    public void setResetOnFinish(boolean resetOnFinish) {
        this.resetOnFinish = resetOnFinish;
    }

    /**
     * 获取步进距离
     *
     * @return
     */
    public int getStep() {
        return step;
    }

    /**
     * 设置步进距离
     *
     * @param step
     */
    public void setStep(int step) {
        this.step = step;
    }

    /**
     * 获取步进速度
     *
     * @return
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * 获取滚动状态监听器
     *
     * @return
     */
    public ScrollStatusListener getScrollStatusListener() {
        return mScrollStatusListener;
    }

    /**
     * 设置滚动状态监听器
     *
     * @param scrollStatusListener
     */
    public void setScrollStatusListener(ScrollStatusListener scrollStatusListener) {
        mScrollStatusListener = scrollStatusListener;
    }

    /**
     * 设置步进速度
     *
     * @param speed
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void reset() {
        nowPoint = 0;
        requestLayout();
        resetThread();
    }


    private Thread mScrollThread;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        myHeight = getLineHeight() * getLineCount();
        resetThread();
    }

    private void resetThread() {
        if (mMarqueeRunnable != null) {
            mMarqueeRunnable.stop();
        }
        mMarqueeRunnable = new MarqueeRunnable();
        mScrollThread = new Thread(mMarqueeRunnable);
        mScrollThread.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        TextPaint textPaint = getPaint();
        int currentTextColor = getCurrentTextColor();
        textPaint.setColor(currentTextColor);
        StaticLayout mTextLayout = new StaticLayout(getText(), textPaint,
                canvas.getWidth(), Layout.Alignment.ALIGN_NORMAL,
                getLineSpacingMultiplier(), getLineSpacingExtra(), false);
        canvas.save();
        float textX = 0;
        float textY = nowPoint;
        canvas.translate(textX, textY);
        mTextLayout.draw(canvas);
        canvas.restore();
    }

    private int nowPoint;
    private int myHeight;

    private final class MarqueeRunnable implements Runnable {
        private volatile boolean finished = false;

        public void stop() {
            finished = true;
        }

        public MarqueeRunnable() {
        }

        @Override
        public void run() {
            if (mScrollStatusListener != null) {
                mScrollStatusListener.onScrollPrepare();
            }
            try {
                TimeUnit.SECONDS.sleep(delayStart);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (mScrollStatusListener != null) {
                mScrollStatusListener.onScrollStart();
            }
            while (!finished) {
                if (step == 0) {
                    break;
                }
                nowPoint -= step;
                if (myHeight != 0 && nowPoint < -myHeight) {
                    if (resetOnFinish) {
                        nowPoint = 0;
                        postInvalidate();
                    }
                    if (mScrollStatusListener != null) {
                        mScrollStatusListener.onScrollStop();
                    }
                    break;
                }
                postInvalidate();
                try {
                    Thread.sleep(speed * 50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public interface ScrollStatusListener {
        void onScrollPrepare();

        void onScrollStart();

        void onScrollStop();

    }
}
