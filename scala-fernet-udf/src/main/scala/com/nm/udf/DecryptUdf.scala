package com.nm.udf

import com.macasaet.fernet.{Key, StringValidator, Token}
import org.apache.hadoop.hive.ql.exec.UDF
import java.time.{Duration, Instant}

class Validator extends StringValidator {

  override def getTimeToLive() : java.time.temporal.TemporalAmount = {
    Duration.ofSeconds(Instant.MAX.getEpochSecond());
  }
}

class DecryptUdf extends UDF {

  def evaluate(inputVal: String, sparkKey : String): String = {

    if( inputVal != null && inputVal!="" ) {
      Token
        .fromString(inputVal)
        .validateAndDecrypt(new Key(sparkKey), new Validator)
    } else return inputVal
  }
}
