import drools.grailsgorm.DroolsRule
import drools.grailsgorm.Casa

class BootStrap {

    def init = { servletContext ->
        new Casa(dono: "Felix").save(flush: true)

        new DroolsRule(chave: "felix_casa_ligar", descricao: "Ligar ArCondicionado da casa do felix",
                regra: '''
                    import drools.grailsgorm.Casa
                    import drools.grailsgorm.Natureza
                    import drools.grailsgorm.ArCondicionado

                    rule "Ligar ar-condicionado do Felix quanto temperatura maior que 28 graus"
                        when
                            Casa( dono == "Felix", $arCondicionado: arCondicionado )
                            Natureza( temperatura > 26 )
                        then
                            $arCondicionado.ligar();
                        end''').save(flush: true)
        new DroolsRule(chave: "felix_casa_desligar", descricao: "Desligar ArCondicionado da casa do felix",
                regra: '''
                    import drools.grailsgorm.Casa
                    import drools.grailsgorm.Natureza
                    import drools.grailsgorm.ArCondicionado

                    rule "Ligar ar-condicionado do Felix quanto temperatura menor que 22 graus"
                        when
                            Casa( dono == "Felix", $arCondicionado: arCondicionado )
                            Natureza( temperatura < 22 )
                        then
                            $arCondicionado.desligar();
                        end''').save(flush: true)
    }
    def destroy = {
    }
}
