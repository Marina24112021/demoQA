package git;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearchTest {
    @BeforeAll
    static void beforeall(){
        Configuration.browserSize = "1920x1080";
        Configuration.reopenBrowserOnFail = false;//для откладки тестов
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void shouldFindJUnit5CodeOnSelenideWikiPageTest (){
        open("/selenide/selenide");
        $("a[href*='wiki'][id=wiki-tab]").click();
        $("div[class=markdown-body]").shouldHave(text("Soft assertions"));
        $("a[href*='SoftAssertions']").click();

        $("#wiki-body").shouldHave(text("""
                @ExtendWith({SoftAssertsExtension.class})
                class Tests {
                  @Test
                  void test() {
                    Configuration.assertionMode = SOFT;
                    open("page.html");
                                
                    $("#first").should(visible).click();
                    $("#second").should(visible).click();
                  }
                }
                """));

        //sleep(5000);
    }
}
/*Разработайте следующий автотест:
 - Откройте страницу Selenide в Github
 - Перейдите в раздел Wiki проекта
 - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
 - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
*/
