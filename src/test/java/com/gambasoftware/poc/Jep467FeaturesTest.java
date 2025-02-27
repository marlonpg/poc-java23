package com.gambasoftware.poc;


/// JEP 467: Markdown Documentation Comments
///
/// ## Features Demonstrated
/// - Markdown headings (`#`, `##`, `###`).
/// - Lists (both ordered and unordered).
/// - Inline code (`like_this`) and code blocks.
/// - Links and emphasis.
/// ### Output Using `javadoc` Tool:
/// If you run the `javadoc` tool with `--enable-preview`, and view the generated HTML documentation in a browser, the Markdown will render beautifully.
/// #### Example Command:
/// ```bash
/// javadoc --source 23 --enable-preview Jep467FeaturesTest.java
/// ```
public class Jep467FeaturesTest {
    /// ## Adds Two Numbers
    ///
    /// Adds two integers.
    ///
    /// ### Parameters
    /// - `a`: The first number.
    /// - `b`: The second number.
    ///
    /// ### Returns
    /// The sum of the two integers.
    ///
    /// Example:
    /// ```java
    /// MarkdownExample example = new MarkdownExample();
    /// int result = example.add(5, 7);
    /// System.out.println(result); // 12
    /// ```
    ///
    /// @param a The first integer.
    /// @param b The second integer.
    /// @return The sum of `a` and `b`.
    public int add(int a, int b) {
        return a + b;
    }

}
