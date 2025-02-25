/// JEP 477: Implicitly Declared Classes and Instance Main Methods (Third Preview)
/// - Reduces boilerplate by allowing programs without explicit class declarations and static methods.
/// - Beginner friendly, where it lowers the learning curve by eliminating complex concepts like `public static void main` from the start.
/// - Reduce the ceremony of writing other kinds of small programs, such as scripts and command-line utilities.

String greeting() {
    return "Hello, World!";
}

void main() {
    println(greeting());
}
