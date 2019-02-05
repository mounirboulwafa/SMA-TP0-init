package agents;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;

public class Achteur extends Agent {

    @Override
    protected void setup() {
        System.out.println("Agent : " + this.getAID().getName() + " is starting ...");

        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                ACLMessage message = new ACLMessage(ACLMessage.INFORM);
                message.addReceiver(new AID("Vendeur", AID.ISLOCALNAME));
                message.setContent("Je chercher un live a acheter !!");
                send(message);
            }
        });

        addBehaviour(new TickerBehaviour(this, 2000) {
            @Override
            protected void onTick() {
//                ACLMessage message = new ACLMessage(ACLMessage.INFORM);
//                message.addReceiver(new AID("Vendeur", AID.ISLOCALNAME));
//                message.setContent("Je chercher un live a acheter !!");
//                send(message);

                ACLMessage msg = myAgent.receive();
                if (msg != null) {
                    System.out.println(msg.getSender().getLocalName() + " : " + msg.getContent());
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
