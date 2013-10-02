/*
 * Copyright (c) 2013, Luigi R. Viggiano
 * All rights reserved.
 *
 * This software is distributable under the BSD license.
 * See the terms of the BSD license in the documentation provided with this software.
 */

package org.aeonbits.owner;

import java.util.Map;
import java.util.Properties;

/**
 * Factory class to instantiate {@link Config} instances.
 * By default a {link Config} sub-interface is associated to a property having the same package name and class name as
 * the interface itself.
 * <p/>
 * Method names are mapped to property names contained in the property files.
 *
 * @since 1.0.5
 * @author Luigi R. Viggiano
 */
public interface ConfigFactoryInstance {

    /**
     * Creates a {@link Config} instance from the specified interface
     *
     * @param clazz   the interface extending from {@link Config} that you want to instantiate.
     * @param imports additional variables to be used to resolve the properties.
     * @param <T>     type of the interface.
     * @return an object implementing the given interface, which maps methods to property values.
     * @since 1.0.5
     */
    public <T extends Config> T create(Class<? extends T> clazz, Map<?, ?>... imports);

    /**
     * Returns the value for a given property.
     *
     * @param key the key for the property
     * @return the value for the property, or <tt>null</tt> if the property is not set.
     * @since 1.0.5
     */
    public String getProperty(String key);

    /**
     * Set a property in the ConfigFactory. Those properties will be used to expand variables specified in the `@Source`
     * annotation, or by the ConfigFactory to configure its own behavior.
     *
     * @param key   the key for the property.
     * @param value the value for the property.
     * @return the old value.
     * @since 1.0.5
     */
    public String setProperty(String key, String value);

    /**
     * Clears the value for the property having the given key. This means, that the given property is removed.
     *
     * @param key the key for the property to remove.
     * @return the old value for the given key, or <tt>null</tt> if the property was not set.
     * @since 1.0.5
     */
    public String clearProperty(String key);

    /**
     * Those properties will be used to expand variables specified in the `@Source` annotation, or by the ConfigFactory
     * to configure its own behavior.
     *
     * @return the properties in the ConfigFactory
     * @since 1.0.5
     */
    public Properties getProperties();

    /**
     * Those properties will be used to expand variables specified in the `@Source` annotation, or by the ConfigFactory
     * to configure its own behavior.
     *
     * @param properties the properties to set in the config Factory.
     * @since 1.0.5
     */
    public void setProperties(Properties properties);

}
