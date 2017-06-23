package com.luxoft.training.javase.bankapp;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Example1 {

	public static Map<String, String> executeScript(String fileName, Map<String, String> variables) throws Exception {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine1 = manager.getEngineByName("nashorn");

		for (Map.Entry<String, String> entry : variables.entrySet())
            engine1.put(entry.getKey(), entry.getValue());

        Bindings bindings = engine1.createBindings();
        Object eval = engine1.eval(new FileReader(fileName));

        Map<String, String> result = new HashMap<>();

        for (Map.Entry<String, Object> entry : bindings.entrySet())
            result.put(entry.getKey(), entry.getValue().toString());

        result.put("result", eval.toString());

		return result;
	}
}
