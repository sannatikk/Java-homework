package exercises;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Map;

import org.junit.jupiter.api.*;

@DisplayName("Character Counter")
public class CharacterCounterTest {
  private static MethodHandle countHandle; 

    @BeforeEach
    public void setUp() throws Exception {
      try {
        MethodType methodType = MethodType.methodType(Map.class, String.class);
        countHandle = MethodHandles.lookup().findVirtual(CharacterCounter.class, "count", methodType);  
      } catch (NoSuchMethodException e) {
        assertTrue(false, "CharacterCounter class or its constructor is wrong");    
      }
    }  

    @Test
    @DisplayName("Test 1: Counting characters in 'hello'")
    public void testHello() throws Throwable {
        CharacterCounter cc = new CharacterCounter();
        // Map<Character, Integer> result = cc.count("hello");
        Map<Character, Integer> result = (Map<Character, Integer>)countHandle.invoke(cc,"hello");
        // Expected result: {'h': 1, 'e': 1, 'l': 2, 'o': 1}
        assertEquals(4, result.size()); 
        assertEquals(1, result.get('h'));
        assertEquals(1, result.get('e'));
        assertEquals(2, result.get('l'));
        assertEquals(1, result.get('o'));
    }

    @Test
    @DisplayName("Test 2: Counting characters in 'concurrent'")
    public void testConcurrent() throws Throwable {
        CharacterCounter cc = new CharacterCounter();
        Map<Character, Integer> result = (Map<Character, Integer>)countHandle.invoke(cc,"concurrent");

        // Expected result: {'c': 2, 'o': 1, 'n': 2, 'u': 1, 'r': 2, 'e': 1, 't': 1}
        assertEquals(7, result.size());
        assertEquals(2, result.get('c'));
        assertEquals(1, result.get('o'));
        assertEquals(2, result.get('n'));
        assertEquals(1, result.get('u'));
        assertEquals(2, result.get('r'));
        assertEquals(1, result.get('e'));
        assertEquals(1, result.get('t'));
    }

    @Test
    @DisplayName("Test 3: Input string is empty")
    public void testEmptyString() throws Throwable {
        CharacterCounter cc = new CharacterCounter();
        Map<Character, Integer> result = (Map<Character, Integer>)countHandle.invoke(cc,"");

        // Expected result: empty map
        assertTrue(result.isEmpty());
    }

}
