package ladydi.encoders

import org.apache.spark.ml.UnaryTransformer
import org.apache.spark.ml.util.Identifiable
import org.apache.spark.sql.types.{StringType, DataType}

/**
  * Created by zafshar on 3/7/16.
  */
class StringNullEncoder (override val uid: String)
  extends UnaryTransformer[java.lang.Object, String, StringNullEncoder]  {

  def this() = this(Identifiable.randomUID("nullEncoder"))


  protected def createTransformFunc: java.lang.Object => String = {
    StringNullEncoder.transform
  }

  protected def outputDataType: DataType = StringType

}

object StringNullEncoder {

  def load(path: String): StringNullEncoder = new StringNullEncoder()

  def transform (x: java.lang.Object): String = {
    if (x == null) "NULL" ; else x.toString
  }
}