package server.network;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

import gherkin.ast.Location;
import io.javalin.ApiBuilder.EndpointGroup;
import io.javalin.Context;
import io.javalin.Handler;
import io.javalin.Javalin;
import utilities.Config;

public class StartServer {
	public static void main(String[] argv) {
		final Javalin app = Javalin.create()
	            .port(Config.DEFAULT_PORT)
	            .enableStaticFiles("/public")
	            .start();
		
		app.routes(new EndpointGroup() {
			
			@Override
			public void addEndpoints() {
				app.get("/", new Handler() {
					
					@Override
					public void handle(Context ctx) throws Exception {
						Map<String, String> map = new HashMap<String, String>();
						ctx.renderVelocity("/velocity/home.vm");
					}
				});
			}
		});
	}
}
