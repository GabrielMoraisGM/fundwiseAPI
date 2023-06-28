package com.fund.wise.api.fundwise.model.enumerated;

/**
 *
 */
public enum EnumTipoOperacao {
    COMPRA(1, "Compra"),
    VENDA(2, "Venda"),
    SUBSCRICAO(3, "Subscrição");

    private int key;
    private String value;

    EnumTipoOperacao(int key, String value){
        this.key = key;
        this.value = value;
    }

    public int getKey(){
        for (EnumTipoOperacao enumItem: EnumTipoOperacao.values()) {
            if(key == enumItem.key) return enumItem.key;
        }
        throw new ArrayIndexOutOfBoundsException("A chave inserida não corresponde a nenhuma operação válida");
    }

    public static String getValue(int valor){
        for (EnumTipoOperacao enumItem: EnumTipoOperacao.values()) {
            if (valor == enumItem.key) return enumItem.value;
        }
        throw new ArrayIndexOutOfBoundsException("A chave inserida não corresponde a nenhuma operação válida");
    }
}
