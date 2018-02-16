package sk.akademiasovy.resources;


import io.dropwizard.jersey.PATCH;
import jdk.nashorn.internal.objects.annotations.Getter;
import sk.akademiasovy.db.SqlConn;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/heroes")
public class Heroes {

    @GET
    @Path("/salary/{heroName}")
    @Produces(MediaType.APPLICATION_JSON)

    public String getSalary(@PathParam("heroName") String name){
        System.out.println(name);

        String salary= new SqlConn().getSalary(name);
        System.out.println(salary);

        String res = "showSalary({\"name\":\""+salary+"\"})";
        System.out.println(res);

        return res;
    }

    @GET
    @Path("/supername")
    @Produces(MediaType.APPLICATION_JSON)

    public String getHeroesName(){
        List<String> heroes=new SqlConn().getHeroes();
        System.out.println(heroes);

        boolean b=false;
        String result= "showHeroes({\"name\":[";
        for(String temp:heroes) {
            if (b == true) {
                result += ',';
            } else
                b = true;

            result += "\"" + temp + "\"";
        }
        result+="]})";
        return result;

    }

    @GET
    @Path("/civil/{hero}")
    @Produces(MediaType.APPLICATION_JSON)

    public String getCivil(@PathParam("hero") String name){
        System.out.println(name);

        String civilSurrName= new SqlConn().getCivilSurrName(name);
        System.out.println(name);

        String res = "showCivilSurrname({\"name\":\""+civilSurrName+"\"})";
        System.out.println(res);

        return res;
    }
}
