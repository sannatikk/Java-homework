package exercises;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NotificationTest {
    
    private static MethodHandle emailSendHandle;
    private static MethodHandle smsSendHandle;
    private static MethodHandle emailFormatHandle;
    private static MethodHandle smsFormatHandle;
    private static Constructor<?> emailConstructor;
    private static Constructor<?> smsConstructor;
    
    @BeforeEach
    public void setUp() throws Exception {
        try {
            // Test that Shape is abstract class
            Class<?> clazz = Sendable.class; 
            boolean isAbstract = Modifier.isInterface(clazz.getModifiers());
            if (isAbstract == false) {
                assertTrue(false, "Sendable class must be interface");
            }

            // Check inheritance
            Class<?> en = EmailNotification.class;
            Class<?> supere = en.getSuperclass();
            if (supere.getName().equals("exercises.Notification") == false) {
                assertTrue(false, "EmailNotification must inherit Notification");
            }
            Class<?> sn = SMSNotification.class;
            Class<?> supers = sn.getSuperclass();
            if (supers.getName().equals("exercises.Notification") == false) {
                assertTrue(false, "SMSNotification must inherit Notification");
            }

            // Setup for EmailNotification class
            Class<?> emailClass = Class.forName("exercises.EmailNotification");
            emailConstructor = emailClass.getConstructor(String.class, String.class);
            MethodType emailFormatType = MethodType.methodType(String.class);
            emailFormatHandle = MethodHandles.lookup().findVirtual(emailClass, "formatMessage", emailFormatType);
            MethodType emailSendType = MethodType.methodType(String.class);
            emailSendHandle = MethodHandles.lookup().findVirtual(emailClass, "send", emailSendType);

            // Setup for SMSNotification class
            Class<?> smsClass = Class.forName("exercises.SMSNotification");
            smsConstructor = smsClass.getConstructor(String.class, String.class);
            MethodType smsFormatType = MethodType.methodType(String.class);
            smsFormatHandle = MethodHandles.lookup().findVirtual(smsClass, "formatMessage", smsFormatType);
            MethodType smsSendType = MethodType.methodType(String.class);
            smsSendHandle = MethodHandles.lookup().findVirtual(smsClass, "send", smsSendType);

        } catch (Exception e) {
            assertTrue(false, "Either EmailNotification or SMSNotification class or their constructors are missing");
        }
    }
    
    @Test
    @DisplayName("Test sending email")
    public void testSendEmail() throws Throwable {
        try {
            Object[] initargs = { "my@email.com", "Hello!" };
            Object email = emailConstructor.newInstance(initargs);

            // Test formatMessage
            String expected = "my@email.com: Hello!";
            String actual = (String) emailFormatHandle.invoke(email);
            assertEquals(expected, actual, "Error in formatMessage() output");

            // Test send
            Object[] initargs2 = { "hello@gmail.com", "Good bye!" };
            email = emailConstructor.newInstance(initargs2);
            
            expected = "Sent email hello@gmail.com: Good bye!";
            actual = (String) emailSendHandle.invoke(email);
            assertEquals(expected, actual, "Error in send() method output");
            
        } catch (Exception e) {
            assertTrue(false, "Email class methods formatMessage() or send() could not be tested");
        }
    }

    @Test
    @DisplayName("Test sending SMS")
    public void testSendSMS() throws Throwable {
        try {
            // Test formatMessage
            Object[] initargs = { "0123456789", "Hello!" };
            Object sms = smsConstructor.newInstance(initargs);

            String expected = "+358-123456789: Hello!";
            String actual = (String) smsFormatHandle.invoke(sms);
            assertEquals(expected, actual, "Error in formatMessage() output");

            // Test send
            Object[] initargs2 = { "0987654321", "Good bye!" };
            sms = smsConstructor.newInstance(initargs2);
            
            expected = "Sent SMS +358-987654321: Good bye!";
            actual = (String) smsSendHandle.invoke(sms);
            assertEquals(expected, actual, "Error in send() method output");

        } catch (Exception e) {
            assertTrue(false, "SMS class methods formatMessage() or send() could not be tested");
        }
    }    
}
