package com.github.bgomar.bgconsolelogger.tools.hash;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Optional;

public class SHA1HashMethod implements HashMethod {
    public static final String NAME = "SHA1";

    @Override
    public Optional<String> generateHash(String input) {
        try {
            if (input.isBlank()) {
                return Optional.of("");
            }
            return Optional.of(DigestUtils.sha1Hex(input));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public String name() {
        return NAME;
    }
}