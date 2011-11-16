package drools.grailsgorm

class Casa {
    String dono
    ArCondicionado arCondicionado = new ArCondicionado(this)
    static constraints = {
    }
    static transients = ['arCondicionado']
}
