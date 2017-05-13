package com.vz.onosproject.Builder;

import org.onlab.packet.Ip4Address;

import java.math.BigInteger;
import java.nio.ByteBuffer;

/**
 * Created by kspviswa-onos-mcord on 13/5/17.
 */
public class FpcBuilder {
    private static byte CREATE_SESSION_TYPE = 0b0000_0001;
    private static byte MODIFY_DL_BEARER_TYPE = 0b0000_0010;
    private static byte DELETE_SESSION_TYPE = 0b0000_0011;
    private static byte MODIFY_UL_BEARER_TYPE = 0b0000_0100;
    private static byte CREATE_UL_BEARER_TYPE = 0b0000_0101;
    private static byte CREATE_DL_BEARER_TYPE = 0b0000_0110;
    private static byte DELETE_BEARER_TYPE = 0b0000_0110;
    private static byte HELLO = 0b0000_1000;
    private static byte BYE = 0b0000_1001;

    public static String BROADCAST_TOPIC = "0";

    public static ByteBuffer buildCreateSession(
            String dpn,
            String imsi,
            String ue_ip,
            String lbi,
            String s1u_sgw_gtpu_ipv4,
            String s1u_sgw_gtpu_teid
    ) {
        return create_session(
                dpn,
                new BigInteger(imsi),
                Long.getLong(ue_ip),
                Short.parseShort(lbi),
                s1u_sgw_gtpu_ipv4,
                Long.getLong(s1u_sgw_gtpu_teid)
        );
    }

    public static ByteBuffer create_session(
            String dpn,
            BigInteger imsi,
            Long ue_ip,
            Short lbi,
            String s1u_sgw_gtpu_ipv4,
            Long s1u_sgw_gtpu_teid  // Although this is intended to be a Uint32
            //UlTftTable ul_tft_table
    )
    {
        //Create byte[] from arguments
        ByteBuffer bb = ByteBuffer.allocate(24);
        bb.put(dpn.getBytes())
                .put(CREATE_SESSION_TYPE)
                .put(toUint64(imsi))
                .put(toUint8(lbi))
                .put(toUint32(ue_ip))
                .put(toUint32(s1u_sgw_gtpu_teid))
                .put(toUint32(Long.getLong(s1u_sgw_gtpu_ipv4)));

        return bb;
    }


    public static byte toUint8(Short value) {
        return value.byteValue();
    }


    public static byte[] toUint16(Short value) {
        return new byte[]{(byte)(value>>>8),(byte)(value&0xFF)};
    }


    public static byte[] toUint32(long value) {
        return new byte[]{(byte)(value>>>24),(byte)(value>>>16),(byte)(value>>>8),(byte)(value&0xFF)};
    }


    public static byte[] toUint64(BigInteger value) {
        return new byte[]{value.shiftRight(56).byteValue(),value.shiftRight(48).byteValue(),value.shiftRight(40).byteValue(),
                value.shiftRight(32).byteValue(),value.shiftRight(24).byteValue(),value.shiftRight(16).byteValue(),
                value.shiftRight(8).byteValue(),value.and(BigInteger.valueOf(0xFF)).byteValue()};
    }
}
