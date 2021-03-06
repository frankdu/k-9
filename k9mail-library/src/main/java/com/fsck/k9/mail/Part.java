
package com.fsck.k9.mail;

import java.io.IOException;
import java.io.OutputStream;

public interface Part {
    void addHeader(String name, String value) throws MessagingException;

    void removeHeader(String name) throws MessagingException;

    void setHeader(String name, String value) throws MessagingException;

    Body getBody();

    String getContentType() throws MessagingException;

    String getDisposition() throws MessagingException;

    String getContentId() throws MessagingException;

    String[] getHeader(String name) throws MessagingException;

    boolean isMimeType(String mimeType) throws MessagingException;

    String getMimeType() throws MessagingException;

    void setBody(Body body) throws MessagingException;

    void writeTo(OutputStream out) throws IOException, MessagingException;

    /**
     * Called just prior to transmission, once the type of transport is known to
     * be 7bit.
     * <p>
     * All bodies that are 8bit will be converted to 7bit and recursed if of
     * type {@link CompositeBody}, or will be converted to quoted-printable in all other
     * cases. Bodies with encodings other than 8bit remain unchanged.
     *
     * @throws MessagingException
     *
     */
    //TODO perhaps it would be clearer to use a flag "force7bit" in writeTo
    void setUsing7bitTransport() throws MessagingException;
}
