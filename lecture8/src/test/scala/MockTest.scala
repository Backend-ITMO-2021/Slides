import TestUtils.withServer
import utest.{TestSuite, Tests, test}

object MockTest extends TestSuite {
  val tests = Tests {
    test("success") - withServer(MockApplication) { host =>
      val success = requests.get(host)

      assert(success.text().contains("Scala Chat!"))
      assert(success.text().contains("alice"))
      assert(success.text().contains("Hello World!"))
      assert(success.text().contains("bob"))
      assert(success.text().contains("I am cow, hear me moo"))
      assert(success.statusCode == 200)
    }
  }
}