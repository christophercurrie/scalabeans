/**
 * Copyright (c) 2011 ScalaStuff.org (joint venture of Alexander Dvorkovyy and Ruud Diterwich)
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.scalastuff.proto

import com.dyuproject.protostuff.Input
import value.RepeatedValueHandler

trait RepeatedField[B <: AnyRef] extends MutableField[B] {

  override val valueHandler: RepeatedValueHandler

  override val repeated = true

  def newBuilder() = new Builder()

  class Builder {
    private[this] val builder = valueHandler.newBuilder()

    def tag = RepeatedField.this.tag

    def mergeElementFrom(input: Input) {
      val elem = valueHandler.readElementFrom(input)
      builder += elem
    }

    def sinkTo(obj: B) {
     RepeatedField.this.setValue(obj, builder.result())
    }
  }

}

