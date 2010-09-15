/*
 * Copyright 2002-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.integration.config.xml;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * @author Mark Fisher
 * @since 2.0
 */
public class JsonToObjectTransformerParser extends AbstractTransformerParser {

	@Override
	protected String getTransformerClassName() {
		return "org.springframework.integration.json.JsonToObjectTransformer";
	}

	@Override
	protected void parseTransformer(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
		String type = element.getAttribute("type");
		String objectMapper = element.getAttribute("object-mapper");
		builder.addConstructorArgValue(type);
		if (StringUtils.hasText(objectMapper)) {
			builder.addConstructorArgReference(objectMapper);
		}
	}

}
