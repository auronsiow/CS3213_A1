import java.util.*;

public class KWICPipeline implements IPipeline{

	private Vector<IComponent> vec_Components;
	
	public KWICPipeline() {
		vec_Components = new Vector<IComponent>();
	}
	
	@Override
	public void addLink(IComponent link) {
		vec_Components.add(link);
	}

	@Override
	public void process() {
		for(IComponent i : vec_Components)
			i.process();
	}

}
