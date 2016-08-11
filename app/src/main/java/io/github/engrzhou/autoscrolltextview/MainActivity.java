package io.github.engrzhou.autoscrolltextview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;

import io.github.engrzhou.autoscrolllib.AutoVerticalScrollTextView;

public class MainActivity extends AppCompatActivity implements AutoVerticalScrollTextView.ScrollStatusListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private AutoVerticalScrollTextView autoScrollTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        autoScrollTextView = (AutoVerticalScrollTextView) findViewById(R.id.auto_scroll_text);
        autoScrollTextView.setText(Html.fromHtml("<p>\n" +
                "作者：王凌珊<br />\n" +
                "链接：<a href=\"https://www.zhihu.com/question/22640649/answer/25443059\" target=\"_blank\">https://www.zhihu.com/question/22640649/answer/25443059</a><br />\n" +
                "来源：知乎<br />\n" +
                "著作权归作者所有，转载请联系作者获得授权。<br />\n" +
                "<div class=\"zm-editable-content clearfix\">\n" +
                "生活之所让人热爱处，在于那些或喜或悲、丰富多彩的经历，而这些经历沉淀下来，反过来又能激起我们更多的生活热情，进而促使我们去体验更广阔的生活，构成一个<b>良性循环</b>。反之，缺乏内容、日复一日、年复一年的机械生活，如同一潭死水，是没有激情可言的，缺乏激情的生活，又会进一步阻碍我们拓展人生体验，从而进入一个<b>恶性循环</b>。所以，<b>重点就是不要让自己陷入恶循环中，主动向良性循环靠拢</b>：或者<b>调动精神力量主动挑起生活激情</b>，譬如以 “大多数人的努力程度之低，根本轮不到去拼天赋” 这类话语激励自己，又譬如挖掘想要让家人和自己过上更富足生活的原始欲望，再如寻找心底深处的人生梦想，等等；又或者<b>主动改变自己的生活状态，拓展生活边界</b>，<b>去经历更广阔的人生，</b>譬如去接触那些往日与自己的生活圈没有交集的形形色色的人，又譬如去做那些往常不曾涉足的领域，改变也许很大，也许仅仅是把周末宅在家里变成去健身房这么简单而已。<br />\n" +
                "给题主推荐一本书，正好对应这个问题：<b>《我怎样设计飞机》</b>。作者是洛克希德的总工程师兼董事长 <a href=\"//link.zhihu.com/?target=http%3A/en.wikipedia.org/wiki/Clarence_Johnson\" class=\" wrap external\" target=\"_blank\">Kelly Johnson (engineer)<i class=\"icon-external\"></i></a> ，此书为其晚年的回忆录。 我原本想看这位天才卓绝的飞机工程师是如何领导洛克希德研发出包括U-2、SR-71黑鸟在内的著名飞机，结果设计飞机没看到（原书名《More Than My Share of It All》，坑爹的翻译），却在朴实的字里行间被作者丰富多彩的一生深深打动。<br />\n" +
                "凯利一生领导设计了40余架飞机，其中很多都是经典之作，1976年试飞的 <a href=\"//link.zhihu.com/?target=http%3A/zh.wikipedia.org/wiki/SR-71\" class=\" wrap external\" target=\"_blank\">SR-71黑鳥式偵察機<i class=\"icon-external\"></i></a> 至今甚至都保持着两项世界纪录，他也因此获奖无数，其中还包括美国金属协会颁发的工程材料成就奖这种非航空领域的奖项（当时的工业金属无法满足黑鸟的需求，作为实验室最新成果的钛合金尚无工业生产方法，凯利竟然带领洛克希德的一众飞机工程师研发出了钛合金工业生产方式）。但最打动我的却不是这些，而是他对生活无比热爱的激情。其实他的人生算不上十分顺遂，出身贫苦，几岁大就给有钱人家洗衣服贴补家用，前后两任深爱的妻子皆因病过世，第二位甚至只和他美满生活了一年就恶疾缠身，此后十年相继做了十几次手术，先后摘除了眼球及右腿截肢，凯利这十年照顾妻子很是不易，早期危险的飞机试飞工作使得他失去了很多朋友，常年高负荷的工作使他患有各种疾病。但不论是幼年的贫苦，或者是之后的种种，都没有浇灭凯利那颗热爱生活的心。年幼时，帮佣洗衣之余，凯利有着非常丰富多彩的生活，垒砖头、砍木头这种苦重活儿在他眼里甚至都是有趣的，八九岁时他还兴致勃勃地在小树林里搭过一个小窝棚，十二岁时在图书馆看到的几本关于飞机设计的书更是让彼时的那个少年深深陶醉；成年后，如愿以偿的完成自幼梦想的凯利在投身飞机设计事业之余，还和妻子经营了一个牧场，全书从凯利二十几岁到七八十，牧场时不时出现，最终以凯利在牧场里招待一众七十多岁的老朋友聚餐结尾。热爱生活的人，那种处处流露出的激情，不是三言两语就可以说完。<br />\n" +
                "纵观凯利的一生，绝佳的<b>诠释了前面所述的良性循环</b>，正如这本书最后一段所言：<br />\n" +
                "<blockquote>\n" +
                "<b>在写作本书的过程中，本罗姆.萨克斯医生为我做了第二次心脏三向搭桥手术，算起来在第一次手术后已经过了九年。我生命的最后一章尚未写出。但是，即便今夜上帝就召唤我，我已经享用了生活给我的份额，甚至已经大为超过了。我<u>经历</u>了贫穷与富裕、斗争与成功、平庸与显赫、悲哀与欢乐、幸福和爱情。<br />\n" +
                "已经超过我应得的份额了。<br />\n" +
                "</b> \n" +
                "</blockquote>\n" +
                "<br />\n" +
                "如此心境，可谓达到内心安宁的至境。<br />\n" +
                "共勉。" +
                "</p>"));
        autoScrollTextView.setScrollStatusListener(this);
    }

    @Override
    public void onScrollPrepare() {
        Log.d(TAG, ">>>>>>>>onScrollPrepare()>>>>>>>>>");
    }

    @Override
    public void onScrollStart() {
        Log.d(TAG, ">>>>>>>>onScrollStart()>>>>>>>>>");
    }

    @Override
    public void onScrollStop() {
        Log.d(TAG, ">>>>>>>>onScrollStop()>>>>>>>>>");
    }

    public void restart(View view) {
        autoScrollTextView.setText(Html.fromHtml("<p>\n" +
                "<h2 class=\"question-title\" style=\"font-size:22px;color:#222222;font-family:&quot;background-color:#FFFFFF;\">\n" +
                "丹麦电影《狩猎》好在哪？\n" +
                "</h2>\n" +
                "<div class=\"answer\" style=\"font-family:&quot;font-size:medium;background-color:#FFFFFF;\">\n" +
                "<div class=\"meta\" style=\"font-size:16px;color:#B8B8B8;\">\n" +
                "<img class=\"avatar\" src=\"http://pic2.zhimg.com/2ff5699bb5c6bb5cc5b515ca6d977815_is.jpg\" style=\"width:20px;height:20px;\" />&nbsp;Lesley Yuan，谈场恋爱吧，在胸没下垂之前。\n" +
                "</div>\n" +
                "<div class=\"content\" style=\"color:#444444;margin:10px 0px 25px;\">\n" +
                "<p>\n" +
                "这是我那一年看过的最好的电影。\n" +
                "</p>\n" +
                "<p>\n" +
                "这就是生活：当你处境艰难叫天天不应叫地地不灵连声咒骂这 tmd 还怎么活下去的时候，你发现大部分人都能顽强如小强般奇迹般地活下去；你会为人性的丑陋阴暗而感慨不已，也会为它的美好善良而感动，human，what a complicated creature；当你终于化险为夷柳暗花明守得云开见月明的时候，厄运又会冷不防给你一个迎头痛击，狞笑着告诉你苦难永远不会停止。\n" +
                "</p>\n" +
                "<p>\n" +
                "这是我当时看完《狩猎》后在朋友圈写下的一点感想。一个月过去了，想到这部电影，依然激动不已，以致于我已经在好几个朋友聚会上跟大家强烈推荐，讲故事讲到嗓子冒烟。\n" +
                "</p>"));
        autoScrollTextView.reset();
    }
}
