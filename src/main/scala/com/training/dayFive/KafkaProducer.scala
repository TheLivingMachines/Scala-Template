package com.training.dayFive

import java.util.Properties

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord, RecordMetadata}

import scala.concurrent._
import scala.concurrent.duration._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.util._

object KafkaProducer extends App{

  val kafkaTopic: String = "my-topic"

  val props: Properties = new Properties()
  props.put("bootstrap.servers", "localhost:9092")
  props.put("client.id", "ScalaProducerExample")
  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

  val rnd: Random = new Random()

  val producer: KafkaProducer[String, String] =
    new KafkaProducer[String, String](props)

  val partialResult = (0 to 10).map(_ => {
    val key: String = rnd.nextInt(100).toString
    val msg: String = s"""{ "key": $key }"""
    val data: ProducerRecord[String, String] =
      new ProducerRecord[String, String](kafkaTopic, key, msg)
    println(msg)
    val x: Future[RecordMetadata] = Future {
      producer.send(data).get()
    }
    x.onComplete{
      case Success(o) =>
        println(o.offset())
      case Failure(er) =>
        println(er.getMessage)
    }
    x
  })

  val result: Future[Seq[RecordMetadata]] =
    Future.sequence(partialResult)
  Await.result(result, 600.seconds)

  System.out.println("done!")
  producer.close()
}
