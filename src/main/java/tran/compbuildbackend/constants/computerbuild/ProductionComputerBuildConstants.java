package tran.compbuildbackend.constants.computerbuild;

public class ProductionComputerBuildConstants {

    // dates as strings
    public static final String PURCHASE_DATE_ONE = "2019-11-22";
    public static final String PURCHASE_DATE_TWO = "2019-08-14";

    // purchase locations
    public static final String AMAZON_LOCATION = "Amazon";
    public static final String CENTRAL_COMPUTER_LOCATION = "Central Computers";
    public static final String BEST_BUY_LOCATION = "Best Buy";
    public static final String EVGA_LOCATION = "EVGA's Website";

    // computer build name
    public static final String ALTERNATIVE_RYZEN_BUILD_NAME = "Alternative Ryzen 2019 Build";
    public static final String PROPOSED_RYZEN_BUILD_NAME = "Proposed Ryzen 2019 Build";

    // computer build description
    public static final String DESCRIPTION_FOR_ALT_RYZEN_BUILD = "This is another proposed build for my next system. I " +
            "am considering this build because there are a variety of programs I use that max out my processor usage. " +
            "However, this build will have a higher budget than the build labeled \"Proposed Ryzen 2019 Build.\"";
    public static final String DESCRIPTION_FOR_PROPOSED_RYZEN_BUILD = "This is another proposed build. I am considering " +
            "this build because there are a variety of programs I use that max out my processor usage. However, this" +
            " build will have a lower budget than the build labeled \"Alternative Ryzen 2019 Build.\"";

    // purpose descriptions.
    public static final String PURPOSE_ONE_FOR_ALT_RYZEN_BUILD = "The purpose of this build is that I want to get lower " +
            "CPU temps. In order to get lower temps and with the 3900x I may choose to put the Crosshair VIII Hero into " +
            "the build because according to a benchmark by Hardware Unboxed the Crosshair VIII Hero has a very good VRM " +
            "which tends to stay very low. This is in comparison to an EVGA x58 a1 motherboard I had with my i7-930 that " +
            "when I was running 1.4V and I remember hitting a VRM temperature of well over 92 celsius while just running " +
            "DotA 2 on spectator mode. I realize that my test was not ideal because I was running on a coolermaster " +
            "hyper 212 and currently i'm running a noctua nh-d15s. For the noctua nh-d15s build I am using 1 less 120mm " +
            "intake and 1 less 120mm exhaust fan. I realize my EVGA x58 board was only a $230 board and this crosshair " +
            "board is $380 and is 10 years newer than my older board so the upgrade will be significant. Of course, " +
            "I'm not sure if this is 100% accurate but I do believe that X570 motherboards tend to run very hot so " +
            "I'm considering paying the premium because I want to keep this build for a minimum of 4+ years (like my " +
            "previous two builds). As I mentioned earlier I want to keep the build for 4+ years, although ideally I " +
            "wouldn't want to upgrade the 3900x for at least 6-7 years. I was watching an interesting video by Buildzoid" +
            " where he was monitoring the temperatures on his 3700x on a x370 motherboard and he was running a Prime95 " +
            "test (single-threaded) and then he was talking about how the temperature spike was to be expected because " +
            "the heat was packed into such a small surface area on the processor and that cooling/dissipating that heat " +
            "is very difficult to do even on a more expensive cooler with a high TDP because those heatsinks tend to have" +
            " a very large surface area so they are expected to cool heat over a large amount of surface area and not " +
            "just a very small portion of a processor. Given what was said on this video, I am initially thinking that " +
            "if the silicon is higher quality (such as when I buy the 3900x) the processor wouldn't require as much " +
            "voltage to boost to a certain frequency and this would result in a lower temperature and lower \"spikes.\" " +
            "Of course, currently in august of 2019, the 3900x is always out of stock and the demand is astronomically " +
            "higher than the supply then AMD may not be able to produce the highest quality 3900xs so that's why I don't " +
            "mind waiting. Another reason I don't mind waiting is I definitely want to make sure Ubuntu 19.04 has no issues. " +
            "There may be some things I have forgotten or not written that I may be thinking of. I'll eventually edit this " +
            "and I definitely want to make this more presentable instead one huge blob.";
    public static final String PURPOSE_TWO_FOR_ALT_RYZEN_BUILD = "Regarding the RAM, I don't see myself purchasing any " +
            "very high end ram stick because according to the benchmarks there is a huge amount to be paid for very " +
            "minimal performance. Following what I talked about above, one can argue that I may want to go for a cheaper " +
            "processor such as the 3700x at most or the 3600, or 3600x. The reason I would want to go with the 3900x is " +
            "because I believe the silicon will be of higher quality (better bin).";
    public static final String PURPOSE_THREE_FOR_ALT_RYZEN_BUILD = "Regarding the video card, I don't see myself spending " +
            "more for the video card because I don't see myself gaming at a resolution higher than 1080p. Although I " +
            "currently haven't touched DotA 2 for a while now, I can't imagine playing dota 2 on a 1440p capable monitor, " +
            "a 24\" 1440p to me is just weird. Given what I have discussed above, I feel that a rtx 2060 or a 2060 " +
            "super may be what I want. The reason I don't want to buy a 5700XT is because I have very bad memories of " +
            "the XFX 5770 that I once had and even further back when I was very young I had a ATI Radeon 9800 Pro which " +
            "also had over-heating issues. Following up on the ATI Radeon 9800 Pro, the cooling way back then was " +
            "definitely not as polished and efficient as it is now. However the 5770 I had was up until roughly 2014 " +
            "when I upgraded to my current 760, and even that 5770 had massive temperature issues. One can claim that I " +
            "should just be willing to ticker with it more or perhaps buy a RAIJINTEK MORPHEUS II GPU cooler. That may " +
            "be true but the fact that the amd GPUs run so hot is just a concern for me that makes me hestiate. " +
            "To conclude, I will DEFINITELY do more research on GPUs before I make a purchase. TLDR: I really dislike " +
            "high temps so that's why ryzen 3000 and coffee lake refresh worries me.";

    public static final String PURPOSE_ONE_FOR_PROPOSED_RYZEN_BUILD = "I am creating this build to have a more smooth " +
            "experience when doing productivity workloads, specifically local development so it is easier to follow online " +
            "tutorials/videos and other sources.";
    public static final String PURPOSE_TWO_FOR_PROPOSED_RYZEN_BUILD = "One other reason I would want a modern desktop is " +
            "that I may choose to learn editing programs such as Magix Vegas or one of the Adobe tools and in that case " +
            " a new Ryzen CPU and system would be a huge upgrade from my Haswell or Broadwell processors.";

    // overclocking notes.
    public static final String OVERCLOCKING_NOTE_ONE_FOR_ALT_RYZEN_BUILD = "I don't plan to do much manual overclocking with this build!";
    public static final String OVERCLOCKING_NOTE_ONE_FOR_PROPOSED_RYZEN_BUILD = "I don't believe this build will require manual overclocking.";

    // build notes.
    public static final String BUILD_NOTE_ONE_FOR_ALT_RYZEN_BUILD = "This is just the highest tier of builds that I would" +
            " go for a personal desktop/workstation. I realize that there are more costly motherboards, the 3950x is " +
            "coming out in sept 2019 and I could get the rtx 2080 ti or the 2080 super, etc. I could also get more expensive " +
            "cases as well, higher tier ram/higher frequency low latency.";
    public static final String BUILD_NOTE_ONE_FOR_PROPOSED_RYZEN_BUILD = "This build will be more than sufficient for " +
            "the current tasks I am doing such as development, and using virtual machines to watch videos. Even if " +
            " I were gaming I believe this budget build would be fine as I would prefer to game on 1080p 144hz. If I " +
            " were to upgrade to 1440p/144hz with a 27\" monitor I would just need to upgrade to something such as the " +
            " 2070 super.";
    // directions.
    public static final String DIRECTION_ONE_FOR_ALT_RYZEN_BUILD = "I may update this once I build my next system.";
    public static final String DIRECTION_ONE_FOR_PROPOSED_RYZEN_BUILD = "TBA because I have not built this yet.";

    // computer parts.
    public static final String ALT_RYZEN_BUILD_PROCESSOR_NAME = "Ryzen 9 3900x";
    public static final double ALT_RYZEN_BUILD_PROCESSOR_PRICE = 499.99;
    public static final String ALT_RYZEN_BUILD_PROCESSOR_NOTES = "This is the processor which has a higher L3 " +
            "cache than the 3700x and 3800x. According to some benchmarks this can be really beneficial especially for " +
            "7-Zip x64 decompression.";

    public static final String ALT_RYZEN_BUILD_MOTHERBOARD_NAME = "GIGABYTE X570 AORUS Master";
    public static final double ALT_RYZEN_BUILD_MOTHERBOARD_PRICE = 349.99;
    public static final String ALT_RYZEN_BUILD_MOTHERBOARD_NOTES = "This is a high-end motherboard but not top of " +
            "the line. ASUS claims the VRM on this motherboard is very high quality. According to a few benchmarks " +
            "I've looked at such as one by Hardware Unboxed and a few reviews I've read online this seems to be the case.";

    public static final String RAM_NAME = "Crucial Ballistix Sport LT (BLS2K16G4D30AESB)";
    public static final double RAM_PRICE = 142.43;
    public static final String RAM_NOTE_ONE = "I definitely want 32gb of ram so I can use VMs " +
            "with lots of ram allocated (8gb). I also realize that programs these days are using a lot more memory than" +
            " back in the day. I remember my 2010 build which was very good, my only regret with it is that I should've " +
            "gotten 12gb of ram and not just 6gb. This is LPX ram so it will go well with my Noctua NH-D15s.";

    public static final String CASE_NAME = "Fractal Design R6";
    public static final double CASE_PRICE = 142.99;
    public static final String CASE_NOTES = "This case is highly customizable and highly " +
            "modular. I realize this case is DEFINITELY over kill but I want more to work with than less to work with. " +
            "I am open to other cases though and I may do more research.";

    public static final String ALT_RYZEN_BUILD_VIDEO_CARD_NAME = "EVGA GeForce RTX 2060 SUPER SC";
    public static final double ALT_RYZEN_BUILD_VIDEO_CARD_PRICE = 419.99;
    public static final String ALT_RYZEN_BUILD_VIDEO_CARD_NOTES = "This is the proposed video card but I may go " +
            "with the 1660 as I do not believe I am doing anything too graphic intensive. Development is definitely " +
            "not graphic intensive and I don't plan to play any modern AAA titles/games on high resolutions.";

    public static final String ALT_RYZEN_BUILD_POWER_SUPPLY_NAME = "Seasonic Platinum SSR-850PX";
    public static final double ALT_RYZEN_BUILD_POWER_SUPPLY_PRICE = 149.99;
    public static final String ALT_RYZEN_BUILD_POWER_SUPPLY_NOTES = "I don't have much knowledge on power supplies and" +
            " \"platinum\" may not actually be of higher quality than say \"gold\" but this is just a place holder power " +
            "supply. I've had my 850w corsair since 2010. It is important to note that this was once 131.99 instead of " +
            "149.99 back in August of 2019 or so.";

    public static final String PROPOSED_RYZEN_BUILD_VIDEO_CARD_NAME = "EVGA GeForce GTX 1660 SC ULTRA GAMING (06G-P4-1067-KR)";
    public static final double PROPOSED_RYZEN_BUILD_VIDEO_CARD_PRICE = 229.95;
    public static final String PROPOSED_RYZEN_BUILD_VIDEO_CARD_NOTES = "This is a place holder card. I may go with " +
            "an AMD card possibly, or a 1660ti with this budget.";

    public static final String PROPOSED_RYZEN_BUILD_PROCESSOR_NAME = "Ryzen 7 3700x";
    public static final double PROPOSED_RYZEN_BUILD_PROCESSOR_PRICE = 319.95;
    public static final String PROPOSED_RYZEN_BUILD_PROCESSOR_NOTES = "This is the processor. I am choosing this " +
            "because I want a minimum of 8cores/16 threads (to match the 9900k) and for the processor I buy to be very " +
            "\"snappy\" for \"productivity\" workloads (not sure if development counts as that). I am still considering " +
            "the 3900x at the time of writing this. I don't really care for gaming performance although this would get " +
            "me very high FPS in some of the games (if I even plan to play).";

    public static final String PROPOSED_RYZEN_BUILD_MOTHERBOARD_NAME = "ASRock x570 Taichi";
    public static final double PROPOSED_RYZEN_BUILD_MOTHERBOARD_PRICE = 299.99;
    public static final String PROPOSED_RYZEN_BUILD_MOTHERBOARD_NOTES = "This is a pretty high end board. It has many " +
            "features. I am mostly focusing on the fact that it's VRM is definitely acceptable but I believe the " +
            "Crosshair VIII Hero has VRMs that run much cooler. I will have to do more and in-depth research on this " +
            "motherboard and the crosshair VIII to compare their VRMS and the power delivery system. One thing that I " +
            "very much like on this board is that it has a ps2 port for better keyboard support when going into the " +
            "BIOs. I'm not sure if this would be an issue but on my Z87 motherboard (Haswell) I have an issue with my " +
            "K70 lux not working in the BIOS so I have to use my ps2 port to navigate or just use my mouse.";

    public static final String PROPOSED_RYZEN_BUILD_POWER_SUPPLY_NAME = "Seasonic FOCUS Plus 850 Gold SSR-850FX ";
    public static final double PROPOSED_RYZEN_BUILD_POWER_SUPPLY_PRICE = 124.99;
    public static final String PROPOSED_RYZEN_BUILD_POWER_SUPPLY_NOTES = "Overall, this power supply would be more than "
            + "sufficient. I am curious what the lowest price for this would be if the platinum version was once 131.99 "
            + "because in that case this should be around 106.99 (I assume the platinum and gold should differ by " +
            "about 25 dollars or so. Just like in the alternative build I would have to do more research on PSUs.";
}
