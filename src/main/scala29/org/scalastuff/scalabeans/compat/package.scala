package org.scalastuff.scalabeans

package object compat {
  val ByteCodecs = scala.reflect.generic.ByteCodecs
  val Flags = scala.reflect.generic.Flags
  type Flags = scala.reflect.generic.Flags
  val PickleFormat = scala.reflect.generic.PickleFormat
  type PoorPickleBuffer = scala.reflect.generic.PickleBuffer

  val ConstructorPattern = "init$default$"
}
