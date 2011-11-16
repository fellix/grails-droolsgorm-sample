package drools.grailsgorm

/**
 * Created by IntelliJ IDEA.
 * User: felix
 * Date: 11/16/11
 * Time: 9:12 AM
 * To change this template use File | Settings | File Templates.
 */
class ArCondicionado {
    private boolean ligado = false
    private def casaInstalada;

    ArCondicionado(def casa){
        casaInstalada = casa
    }

    def desligar(){
        //if(ligado){
            new DroolsLog(descricao: "Delisgando ar da casa do "+casaInstalada.dono).save(flush: true)
            ligado = false
        //}
    }

    def ligar(){
        //if(!ligado){
            new DroolsLog(descricao: "Ligando ar da casa do "+casaInstalada.dono).save(flush: true)
            ligado = true
        //}
    }
}
