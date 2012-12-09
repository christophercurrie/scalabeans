package org.scalastuff.scalabeans

package object compat {
  val ByteCodecs = scala.reflect.internal.pickling.ByteCodecs
  val Flags = scala.reflect.internal.Flags
  type Flags = scala.reflect.internal.Flags
  val PickleFormat = scala.reflect.internal.pickling.PickleFormat
  type PoorPickleBuffer = scala.reflect.internal.pickling.PickleBuffer

  val ConstructorPattern = "$lessinit$greater$default$"
}
