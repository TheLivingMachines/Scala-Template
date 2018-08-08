package com.training.dayFive

import java.util.Properties

import org.apache.kafka.clients.consumer.{ConsumerRecord, KafkaConsumer}
import org.apache.kafka.common.serialization.StringDeserializer

import scala.collection.JavaConverters._

object SimpleConsumer extends App {

  val properties = new Properties()
  properties.put("bootstrap.servers", "localhost:9092")
  properties.put("group.id", "consumer-tutorial")
  properties.put("key.deserializer", classOf[StringDeserializer])
  properties.put("value.deserializer", classOf[StringDeserializer])

  val kafkaConsumer = new KafkaConsumer[String, String](properties)
  kafkaConsumer.subscribe(Seq("my-topic").asJava)

  while (true) {
    val results: Iterable[ConsumerRecord[String, String]] =
      kafkaConsumer.poll(2000).asScala
    results.foreach(msg => {
      println(msg.value())
    })
  }

}
