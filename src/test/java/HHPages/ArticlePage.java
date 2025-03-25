package HHPages;

import net.serenitybdd.screenplay.targets.Target;


public class ArticlePage {


    public static Target TimeWithParticularContent = Target.the("{0} time with particular content").
            locatedBy("//*[text()='{0}']/preceding::div[not(contains(@class,'elementor-hidden-desktop'))]/div/ul/li/span[contains(@class,'post-info__item--type-custom') and contains(text(),'min') or contains(text(),'mins')]");

    public static Target ArticleWithArticleName= Target.the("{0} article name").locatedBy("(//h1[normalize-space(text()) = '{0}'])[1]");
	public static Target ArticleInHeroSection = Target.the("{0} Article In Hero Section").
            locatedBy("//div[contains(@class,'landing-swiper-container')]//h2[text()='{0}']");

    public static Target ArticleNameInDetailPage = Target.the("{0} article name in detail page").locatedBy("//h1[normalize-space(text())='{0}']");
    public static Target ArticleContentInDetailPage = Target.the("{0} content in detail page").locatedBy("//*[normalize-space(text())='{0}']");
    public static Target ArticleExcerptInDetailPage = Target.the("{0} excerpt in detail page").locatedBy("//*[normalize-space(text())='{0}']");

	public static Target BreakingNewsSection =Target.the("{0} Article In Breaking News Section").
            locatedBy("//div[contains(@class,'e-swiper-container')]//a[text()='{0}']");





}
