package drools.grailsgorm

import org.drools.builder.KnowledgeBuilder
import org.drools.builder.KnowledgeBuilderFactory
import org.drools.io.ResourceFactory
import org.drools.builder.ResourceType
import org.drools.KnowledgeBase
import org.drools.KnowledgeBaseFactory
import org.drools.runtime.Environment
import org.drools.runtime.StatefulKnowledgeSession

class CasaController {
    static scaffold = Casa

    def temperatura = {
        def temperatura = Integer.parseInt(request.getParameter("temperatura"))
        Natureza natureza = new Natureza(temperatura: temperatura)
        KnowledgeBuilder builder = KnowledgeBuilderFactory.newKnowledgeBuilder()
        DroolsRule.all.each {
            builder.add(ResourceFactory.newByteArrayResource(it.regra.bytes), ResourceType.DRL)
        }
        KnowledgeBase base = KnowledgeBaseFactory.newKnowledgeBase()
        if(builder.hasErrors()){
            new DroolsLog(descricao: "Erro nas regras: ${builder.errors.toString()}").save(flush: true)
        }else{
            base.addKnowledgePackages(builder.knowledgePackages)
            StatefulKnowledgeSession knowledgeSession = base.newStatefulKnowledgeSession()
            knowledgeSession.insert(natureza)
            Casa.all.each {
                knowledgeSession.insert(it)
            }
            knowledgeSession.fireAllRules()
        }
        return [temperatura: temperatura]
    }
}
