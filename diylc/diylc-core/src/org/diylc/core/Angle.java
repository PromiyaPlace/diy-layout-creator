package org.diylc.core;

import java.util.HashMap;
import java.util.Map;

public class Angle {

  private int value;
  
  private Angle(int value) {
    super();
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + value;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Angle other = (Angle) obj;
    if (value != other.value)
      return false;
    return true;
  }
  
  @Override
  public String toString() {   
    return Integer.toString(value);
  }
  
  private static Map<Integer, Angle> valueCache = new HashMap<Integer, Angle>();
  
  public synchronized static Angle of(int angle) {
    valueCache.computeIfAbsent(angle, (value) -> new Angle(value));
    return valueCache.get(angle);
  }
}
