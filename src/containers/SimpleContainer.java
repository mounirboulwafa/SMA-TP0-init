package containers;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;

public class SimpleContainer {
    public static void main(String[] args) throws Exception {
        Runtime runtime = Runtime.instance();
        Profile profile = new ProfileImpl(false);
        profile.setParameter(Profile.MAIN_HOST, "localhost");
        AgentContainer agentContainer = runtime.createAgentContainer(profile);

        AgentController agentController = agentContainer.createNewAgent("Vendeur", "agents.Vendeur", new Object[]{});
        agentController.start();

        AgentController agentController2 = agentContainer.createNewAgent("Achteur", "agents.Achteur", new Object[]{});
        agentController2.start();

    }

}
