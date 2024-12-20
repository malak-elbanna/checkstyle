/*xml
<module name="Checker">
  <module name="TreeWalker">
    <module name="NPathComplexity">
      <property name="max" value="100"/>
    </module>
  </module>
</module>
*/
package com.puppycrawl.tools.checkstyle.checks.metrics.npathcomplexity;

// xdoc section -- start
public abstract class Example2 {
  public void foo() { // violation, NPath complexity is 128 (max allowed is 100)
    int a,b,t,m,n;
    a=b=t=m=n = 0;

    // Complexity is achieved by choosing from 2 options 7 times (2^7 = 128 outcomes)
    if (a > b) { // non-nested if-else decision tree multiplies complexity by 2
      bar();
    } else {
      baz();
    }

    print(t > 1 ? bar() : baz()); // 5 ternary statements multiply complexity by 2^5
    print(t > 2 ? bar() : baz());
    print(t > 3 ? bar() : baz());
    print(t > 4 ? bar() : baz());
    print(t > 5 ? bar() : baz());

    if (m > n) { // multiplies complexity by 2
      baz();
    } else {
      bar();
    }
  }

  public abstract String bar();
  public abstract String baz();
  public abstract void print(String str);
}
// xdoc section -- end
