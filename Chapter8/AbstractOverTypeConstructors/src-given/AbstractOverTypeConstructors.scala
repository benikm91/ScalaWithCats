object AbstractOverTypeConstructors {

  def main(args: Array[String]): Unit = {
    def testTotalUptime(): Unit = {
      val hosts = Map("host1" -> 10, "host2" -> 6)
      val client = new TestUptimeClient(hosts)
      val service = new UptimeService(client)
      val actual = service.getTotalUptime(hosts.keys.toList)
      val expected = hosts.values.sum
      assert(actual == expected)
    }

    testTotalUptime()
  }

}
