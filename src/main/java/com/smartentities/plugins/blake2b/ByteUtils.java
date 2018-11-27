package com.smartentities.plugins.blake2b;

public class ByteUtils {
	
	private final static char[] hexArray = "0123456789ABCDEF".toCharArray();
	
    // little-endian byte order!
    static long bytes2long(final byte[] byteArray, final int offset) {
        return (((long) byteArray[offset] & 0xFF)
                | (((long) byteArray[offset + 1] & 0xFF) << 8)
                | (((long) byteArray[offset + 2] & 0xFF) << 16)
                | (((long) byteArray[offset + 3] & 0xFF) << 24)
                | (((long) byteArray[offset + 4] & 0xFF) << 32)
                | (((long) byteArray[offset + 5] & 0xFF) << 40)
                | (((long) byteArray[offset + 6] & 0xFF) << 48)
                | (((long) byteArray[offset + 7] & 0xFF) << 56));
    }

    // convert one long value in byte array
    // little-endian byte order!
    public static byte[] long2bytes(final long longValue) {
        return new byte[]
                {(byte) longValue, (byte) (longValue >> 8),
                        (byte) (longValue >> 16), (byte) (longValue >> 24),
                        (byte) (longValue >> 32), (byte) (longValue >> 40),
                        (byte) (longValue >> 48), (byte) (longValue >> 56)
                };
    }

    public static long rotr64(final long x, final int rot) {
        return x >>> rot | (x << (64 - rot));
    }
    
    public static String bytesToHex(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    for ( int j = 0; j < bytes.length; j++ ) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = hexArray[v >>> 4];
	        hexChars[j * 2 + 1] = hexArray[v & 0x0F];
	    }
	    return new String(hexChars);
	}
}
