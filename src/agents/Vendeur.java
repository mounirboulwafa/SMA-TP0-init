package agents;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class Vendeur extends Agent {
    @Override
    protected void setup() {
        System.out.println("Agent : " + this.getAID().getName() + " is starting ...");
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage msg = myAgent.receive();
                if (msg != null) {
                    System.out.println(msg.getSender().getLocalName() + " : " + msg.getContent());
/*
   respond
 */
                    ACLMessage respond = new ACLMessage(ACLMessage.INFORM);
                    respond.addReceiver(msg.getSender());
                    respond.setContent("Oui avec plaisir !");
                    send(respond);

                } else
                    block();
            }
        });
    }

    @Override
    protected void beforeMove() {
        System.out.println("Before Migration ...");
        System.out.println("Container : " + this.getContainerController().getName());
    }

    @Override
    protected void afterMove() {
        System.out.println("After Migration ...");
        System.out.println("Container : " + this.getContainerController().getName());

    }

    @Override
    protected void takeDown() {
        System.out.println("Agent distraction ...");
    }
}
