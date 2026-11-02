package com.mycompany.esportmanager;

public class TransaksiLatihan {
    public static void prosesSesi(Staf staf, Pemain pemain) {
        System.out.println("\n===== STRUK SESI LATIHAN =====");
        System.out.println("Pelatih : " + staf.getNama() + " (" + staf.getKode() + ")");
        System.out.println("Pemain  : " + pemain.getNickname() + " (" + pemain.getClass().getSimpleName() + ")");
        System.out.println("Status  : Sesi latihan berhasil dicatat di sistem.");

        pemain.caraLatihan();

        if (pemain instanceof DapatBertanding) {
            ((DapatBertanding) pemain).ikutTurnamen();
        }
        if (pemain instanceof DapatStreaming) {
            ((DapatStreaming) pemain).mulaiStreaming();
        }
        System.out.println("==============================");
    }
}
