package base.jdi;

import base.jdi.pages.IndexPageJdi;
import base.jdi.pages.MetalsColorsPageJdi;
import base.jdi.pages.MetalsColorsPageJdiDP;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;

@JSite("https://epam.github.io/JDI/")
public class JDISite {
    @Url("index.html")
    public static IndexPageJdi indexPageJdi;
    @Url("metals-color.html")
    public static MetalsColorsPageJdi metalsColorsPageJdi;
    public static MetalsColorsPageJdiDP metalsColorsPageJdiDP;
}
