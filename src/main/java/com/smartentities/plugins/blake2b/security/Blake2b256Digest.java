package com.smartentities.plugins.blake2b.security;

import com.smartentities.plugins.blake2b.Blake2b;

public class Blake2b256Digest extends AbstractDigest implements Cloneable {
    private static final int DIGEST_SIZE = 256;

    public Blake2b256Digest() {
        super(Blake2b.BLAKE2_B_256, new Blake2b(DIGEST_SIZE));
    }

    public Object clone() throws CloneNotSupportedException {
        final Blake2b256Digest clone = (Blake2b256Digest) super.clone();

        clone.instance = new Blake2b(instance);

        return clone;
    }


}
