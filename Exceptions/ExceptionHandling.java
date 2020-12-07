public class ExceptionHandling {

    public static void main(String[] args) {
        System.out.println("Test case when input is null!");
        test(null);

        // Ha az input null akkor Runtime Exceptiont
        // fogunk kapni, hiszen ezt csak az else
        // ág kezeli, majd lefut a finally is

        try {
            System.out.println("Test case when input is float!");
            test(1F);
        } catch (Exception ignored) {
            // Ide miért kerül a vezérlés!?
        }

        // float esetén ChildExceptiont kapunk az if
        // ágtól ami aztán a catch ágban ParentExceptiont
        // dob, majd befejezzük a finally ágban a test
        // metódus try-catch blokkját és a main-ben ahol
        // meghívjuk a test metódust a catch ág kezeli a
        // fennmaradó ParentExceptiont

        System.out.println("Test case when input is String!");
        test("string");

        // String esetén ParentExceptiont kapunk,
        // majd kilépünk a programból, emiatt a
        // finally ág már nem fog lefutni
    }

    private static void test(Object input) {
        try {
            System.out.println("Try!");
            if (input instanceof Float) {
                throw new ChildException();
            } else if (input instanceof String) {
                throw new ParentException();
            } else {
                throw new RuntimeException();
            }
        } catch (ChildException e) {
            System.out.println("Child Exception is caught!");
            if (e instanceof ParentException) {
                throw new ParentException();
            }
        } catch (ParentException e) {
            System.out.println("Parent Exception is caught!");
            System.exit(1);
        } catch (Exception e) {
            System.out.println("Exception is caught!");
        } finally {
            System.out.println("Finally!\n");
        }
    }

}