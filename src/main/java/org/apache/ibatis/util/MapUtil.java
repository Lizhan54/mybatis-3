/*
 *    Copyright 2009-2023 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.util;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;

public class MapUtil {
  /**
   * A temporary workaround for Java 8 specific performance issue JDK-8161372 .<br>
   * This class should be removed once we drop Java 8 support.
   *
   * @see <a href=
   *      "https://bugs.openjdk.java.net/browse/JDK-8161372">https://bugs.openjdk.java.net/browse/JDK-8161372</a>
   */
  public static <K, V> V computeIfAbsent(Map<K, V> map, K key, Function<K, V> mappingFunction) {
    V value = map.get(key);
    if (value != null) {
      return value;
    }
    //computeIfAbsent 方法
    //如果指定的键（key）尚未与某个值关联（或者关联的值为null），
    // 则尝试使用提供的映射函数（mappingFunction）计算其值，并将其与指定的键关联起来。
    // 如果键已经与一个非null值关联，则不会调用映射函数，而是直接返回该值。
    return map.computeIfAbsent(key, mappingFunction);
  }

  /**
   * Map.entry(key, value) alternative for Java 8.
   */
  public static <K, V> Entry<K, V> entry(K key, V value) {
    return new AbstractMap.SimpleImmutableEntry<>(key, value);
  }

  private MapUtil() {
  }
}
