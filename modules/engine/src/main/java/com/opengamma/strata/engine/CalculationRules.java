/**
 * Copyright (C) 2015 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.engine;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.joda.beans.Bean;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.ImmutableDefaults;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.opengamma.strata.engine.config.MarketDataRules;
import com.opengamma.strata.engine.config.ReportingRules;
import com.opengamma.strata.engine.config.pricing.PricingRules;
import com.opengamma.strata.engine.marketdata.config.MarketDataConfig;

/**
 * A set of rules that define how the calculation engine should perform calculations.
 * <p>
 * The calculation rules include:
 * <ul>
 *   <li>The pricing rules which define how the calculations should be performed. This includes the model
 *   and any model parameters</li>
 *   <li>The market data rules which specify which items of market data should be used for a calculation,
 *   for example which curve group should be used as the source of curves and which market data feed should
 *   be used to request observable values</li>
 *   <li>The reporting rules define how the results should be reported, including the reporting currency</li>
 *   <li>The configuration needed to build non-observable market data, for example curves or surfaces</li>
 * </ul>
 */
@BeanDefinition
public final class CalculationRules implements ImmutableBean {

  /** The rules defining how calculations should be performed. */
  @PropertyDefinition(validate = "notNull")
  private final PricingRules pricingRules;

  /** The rules defining what market data should be used in each calculation. */
  @PropertyDefinition(validate = "notNull")
  private final MarketDataRules marketDataRules;

  /** The rules defining how calculation results should be reported. */
  @PropertyDefinition(validate = "notNull")
  private final ReportingRules reportingRules;

  /** The configuration needed to build non-observable market data, for example curves or surfaces. */
  @PropertyDefinition(validate = "notNull")
  private final MarketDataConfig marketDataConfig;

  @ImmutableDefaults
  private static void applyDefaults(Builder builder) {
    builder.pricingRules(PricingRules.EMPTY);
    builder.marketDataRules(MarketDataRules.EMPTY);
    builder.reportingRules(ReportingRules.EMPTY);
    builder.marketDataConfig(MarketDataConfig.EMPTY);
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code CalculationRules}.
   * @return the meta-bean, not null
   */
  public static CalculationRules.Meta meta() {
    return CalculationRules.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(CalculationRules.Meta.INSTANCE);
  }

  /**
   * Returns a builder used to create an instance of the bean.
   * @return the builder, not null
   */
  public static CalculationRules.Builder builder() {
    return new CalculationRules.Builder();
  }

  private CalculationRules(
      PricingRules pricingRules,
      MarketDataRules marketDataRules,
      ReportingRules reportingRules,
      MarketDataConfig marketDataConfig) {
    JodaBeanUtils.notNull(pricingRules, "pricingRules");
    JodaBeanUtils.notNull(marketDataRules, "marketDataRules");
    JodaBeanUtils.notNull(reportingRules, "reportingRules");
    JodaBeanUtils.notNull(marketDataConfig, "marketDataConfig");
    this.pricingRules = pricingRules;
    this.marketDataRules = marketDataRules;
    this.reportingRules = reportingRules;
    this.marketDataConfig = marketDataConfig;
  }

  @Override
  public CalculationRules.Meta metaBean() {
    return CalculationRules.Meta.INSTANCE;
  }

  @Override
  public <R> Property<R> property(String propertyName) {
    return metaBean().<R>metaProperty(propertyName).createProperty(this);
  }

  @Override
  public Set<String> propertyNames() {
    return metaBean().metaPropertyMap().keySet();
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the rules defining how calculations should be performed.
   * @return the value of the property, not null
   */
  public PricingRules getPricingRules() {
    return pricingRules;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the rules defining what market data should be used in each calculation.
   * @return the value of the property, not null
   */
  public MarketDataRules getMarketDataRules() {
    return marketDataRules;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the rules defining how calculation results should be reported.
   * @return the value of the property, not null
   */
  public ReportingRules getReportingRules() {
    return reportingRules;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the configuration needed to build non-observable market data, for example curves or surfaces.
   * @return the value of the property, not null
   */
  public MarketDataConfig getMarketDataConfig() {
    return marketDataConfig;
  }

  //-----------------------------------------------------------------------
  /**
   * Returns a builder that allows this bean to be mutated.
   * @return the mutable builder, not null
   */
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      CalculationRules other = (CalculationRules) obj;
      return JodaBeanUtils.equal(getPricingRules(), other.getPricingRules()) &&
          JodaBeanUtils.equal(getMarketDataRules(), other.getMarketDataRules()) &&
          JodaBeanUtils.equal(getReportingRules(), other.getReportingRules()) &&
          JodaBeanUtils.equal(getMarketDataConfig(), other.getMarketDataConfig());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(getPricingRules());
    hash = hash * 31 + JodaBeanUtils.hashCode(getMarketDataRules());
    hash = hash * 31 + JodaBeanUtils.hashCode(getReportingRules());
    hash = hash * 31 + JodaBeanUtils.hashCode(getMarketDataConfig());
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(160);
    buf.append("CalculationRules{");
    buf.append("pricingRules").append('=').append(getPricingRules()).append(',').append(' ');
    buf.append("marketDataRules").append('=').append(getMarketDataRules()).append(',').append(' ');
    buf.append("reportingRules").append('=').append(getReportingRules()).append(',').append(' ');
    buf.append("marketDataConfig").append('=').append(JodaBeanUtils.toString(getMarketDataConfig()));
    buf.append('}');
    return buf.toString();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code CalculationRules}.
   */
  public static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code pricingRules} property.
     */
    private final MetaProperty<PricingRules> pricingRules = DirectMetaProperty.ofImmutable(
        this, "pricingRules", CalculationRules.class, PricingRules.class);
    /**
     * The meta-property for the {@code marketDataRules} property.
     */
    private final MetaProperty<MarketDataRules> marketDataRules = DirectMetaProperty.ofImmutable(
        this, "marketDataRules", CalculationRules.class, MarketDataRules.class);
    /**
     * The meta-property for the {@code reportingRules} property.
     */
    private final MetaProperty<ReportingRules> reportingRules = DirectMetaProperty.ofImmutable(
        this, "reportingRules", CalculationRules.class, ReportingRules.class);
    /**
     * The meta-property for the {@code marketDataConfig} property.
     */
    private final MetaProperty<MarketDataConfig> marketDataConfig = DirectMetaProperty.ofImmutable(
        this, "marketDataConfig", CalculationRules.class, MarketDataConfig.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "pricingRules",
        "marketDataRules",
        "reportingRules",
        "marketDataConfig");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 1055696081:  // pricingRules
          return pricingRules;
        case 363016849:  // marketDataRules
          return marketDataRules;
        case -1647034519:  // reportingRules
          return reportingRules;
        case -2066297624:  // marketDataConfig
          return marketDataConfig;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public CalculationRules.Builder builder() {
      return new CalculationRules.Builder();
    }

    @Override
    public Class<? extends CalculationRules> beanType() {
      return CalculationRules.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code pricingRules} property.
     * @return the meta-property, not null
     */
    public MetaProperty<PricingRules> pricingRules() {
      return pricingRules;
    }

    /**
     * The meta-property for the {@code marketDataRules} property.
     * @return the meta-property, not null
     */
    public MetaProperty<MarketDataRules> marketDataRules() {
      return marketDataRules;
    }

    /**
     * The meta-property for the {@code reportingRules} property.
     * @return the meta-property, not null
     */
    public MetaProperty<ReportingRules> reportingRules() {
      return reportingRules;
    }

    /**
     * The meta-property for the {@code marketDataConfig} property.
     * @return the meta-property, not null
     */
    public MetaProperty<MarketDataConfig> marketDataConfig() {
      return marketDataConfig;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 1055696081:  // pricingRules
          return ((CalculationRules) bean).getPricingRules();
        case 363016849:  // marketDataRules
          return ((CalculationRules) bean).getMarketDataRules();
        case -1647034519:  // reportingRules
          return ((CalculationRules) bean).getReportingRules();
        case -2066297624:  // marketDataConfig
          return ((CalculationRules) bean).getMarketDataConfig();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      metaProperty(propertyName);
      if (quiet) {
        return;
      }
      throw new UnsupportedOperationException("Property cannot be written: " + propertyName);
    }

  }

  //-----------------------------------------------------------------------
  /**
   * The bean-builder for {@code CalculationRules}.
   */
  public static final class Builder extends DirectFieldsBeanBuilder<CalculationRules> {

    private PricingRules pricingRules;
    private MarketDataRules marketDataRules;
    private ReportingRules reportingRules;
    private MarketDataConfig marketDataConfig;

    /**
     * Restricted constructor.
     */
    private Builder() {
      applyDefaults(this);
    }

    /**
     * Restricted copy constructor.
     * @param beanToCopy  the bean to copy from, not null
     */
    private Builder(CalculationRules beanToCopy) {
      this.pricingRules = beanToCopy.getPricingRules();
      this.marketDataRules = beanToCopy.getMarketDataRules();
      this.reportingRules = beanToCopy.getReportingRules();
      this.marketDataConfig = beanToCopy.getMarketDataConfig();
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case 1055696081:  // pricingRules
          return pricingRules;
        case 363016849:  // marketDataRules
          return marketDataRules;
        case -1647034519:  // reportingRules
          return reportingRules;
        case -2066297624:  // marketDataConfig
          return marketDataConfig;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case 1055696081:  // pricingRules
          this.pricingRules = (PricingRules) newValue;
          break;
        case 363016849:  // marketDataRules
          this.marketDataRules = (MarketDataRules) newValue;
          break;
        case -1647034519:  // reportingRules
          this.reportingRules = (ReportingRules) newValue;
          break;
        case -2066297624:  // marketDataConfig
          this.marketDataConfig = (MarketDataConfig) newValue;
          break;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
      return this;
    }

    @Override
    public Builder set(MetaProperty<?> property, Object value) {
      super.set(property, value);
      return this;
    }

    @Override
    public Builder setString(String propertyName, String value) {
      setString(meta().metaProperty(propertyName), value);
      return this;
    }

    @Override
    public Builder setString(MetaProperty<?> property, String value) {
      super.setString(property, value);
      return this;
    }

    @Override
    public Builder setAll(Map<String, ? extends Object> propertyValueMap) {
      super.setAll(propertyValueMap);
      return this;
    }

    @Override
    public CalculationRules build() {
      return new CalculationRules(
          pricingRules,
          marketDataRules,
          reportingRules,
          marketDataConfig);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the {@code pricingRules} property in the builder.
     * @param pricingRules  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder pricingRules(PricingRules pricingRules) {
      JodaBeanUtils.notNull(pricingRules, "pricingRules");
      this.pricingRules = pricingRules;
      return this;
    }

    /**
     * Sets the {@code marketDataRules} property in the builder.
     * @param marketDataRules  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder marketDataRules(MarketDataRules marketDataRules) {
      JodaBeanUtils.notNull(marketDataRules, "marketDataRules");
      this.marketDataRules = marketDataRules;
      return this;
    }

    /**
     * Sets the {@code reportingRules} property in the builder.
     * @param reportingRules  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder reportingRules(ReportingRules reportingRules) {
      JodaBeanUtils.notNull(reportingRules, "reportingRules");
      this.reportingRules = reportingRules;
      return this;
    }

    /**
     * Sets the {@code marketDataConfig} property in the builder.
     * @param marketDataConfig  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder marketDataConfig(MarketDataConfig marketDataConfig) {
      JodaBeanUtils.notNull(marketDataConfig, "marketDataConfig");
      this.marketDataConfig = marketDataConfig;
      return this;
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(160);
      buf.append("CalculationRules.Builder{");
      buf.append("pricingRules").append('=').append(JodaBeanUtils.toString(pricingRules)).append(',').append(' ');
      buf.append("marketDataRules").append('=').append(JodaBeanUtils.toString(marketDataRules)).append(',').append(' ');
      buf.append("reportingRules").append('=').append(JodaBeanUtils.toString(reportingRules)).append(',').append(' ');
      buf.append("marketDataConfig").append('=').append(JodaBeanUtils.toString(marketDataConfig));
      buf.append('}');
      return buf.toString();
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
