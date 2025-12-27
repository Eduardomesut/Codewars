package ejercicioslvl3.lineSafari;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ExampleTests {

  private static char[][] makeGrid(String[] lines) {
    int rows = lines.length;
    int cols = 0;
    for (String s : lines) cols = Math.max(cols, s.length());
    char[][] grid = new char[rows][cols];
    for (int i = 0; i < rows; i++) {
      String s = lines[i];
      for (int j = 0; j < cols; j++) {
        grid[i][j] = (j < s.length()) ? s.charAt(j) : ' ';
      }
    }
    return grid;
  }

  // "Good" examples from the Kata description.
  
  @Test
  public void exGood1() {
    final char grid[][] = makeGrid(new String[] {
    "           ",
    "X---------X",
    "           ",
    "           "
    });
    assertEquals(true, Dinglemouse.line(grid));
  }

  @Test
  public void exGood2() {
    final char grid[][] = makeGrid(new String[] {
    "     ",
    "  X  ",
    "  |  ",
    "  |  ",
    "  X  "
    });
    assertEquals(true, Dinglemouse.line(grid));
  }

  @Test
  public void exGood3() {
    final char grid[][] = makeGrid(new String[] {
    "                    ",    
    "     +--------+     ",
    "  X--+        +--+  ",
    "                 |  ",
    "                 X  ",
    "                    "
    });
    assertEquals(true, Dinglemouse.line(grid));
  }

  @Test
  public void exGood4() {
    final char grid[][] = makeGrid(new String[] {
    "                     ",    
    "    +-------------+  ",
    "    |             |  ",
    " X--+      X------+  ",
    "                     "
    });
    assertEquals(true, Dinglemouse.line(grid));
  }

  @Test
  public void exGood5() {
    final char grid[][] = makeGrid(new String[] {
    "                      ",    
    "   +-------+          ",
    "   |      +++---+     ",
    "X--+      +-+   X     "
    });
    assertEquals(true, Dinglemouse.line(grid));
  }

  // "Bad" examples from the Kata description.
  
  @Test
  public void exBad1() {
    final char grid[][] = makeGrid(new String[] {
    "X-----|----X"
    });
    assertEquals(false, Dinglemouse.line(grid));
  }
  
  @Test
  public void exBad2() {
    final char grid[][] = makeGrid(new String[] {
    " X  ",
    " |  ",
    " +  ",
    " X  "
    });
    assertEquals(false, Dinglemouse.line(grid));
  }

  @Test
  public void exBad3() {
    final char grid[][] = makeGrid(new String[] {
    "   |--------+    ",
    "X---        ---+ ",
    "               | ",
    "               X "
    });
    assertEquals(false, Dinglemouse.line(grid));
  }

  @Test
  public void exBad4() {
    final char grid[][] = makeGrid(new String[] {
    "              ",
    "   +------    ",
    "   |          ",
    "X--+      X   ",
    "              "
    });
    assertEquals(false, Dinglemouse.line(grid));
  }
  
  @Test
  public void exBad5() {
    final char grid[][] = makeGrid(new String[] {
    "      +------+",
    "      |      |",
    "X-----+------+",
    "      |       ",
    "      X       ",
    });
    assertEquals(false, Dinglemouse.line(grid));
  }
  
}
