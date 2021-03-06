package com.camertron.Scuttle;

import com.camertron.SQLParser.SQLParser;
import com.camertron.Scuttle.Resolver.AssociationResolver;
import org.antlr.v4.runtime.misc.NotNull;

public class LimitVisitor extends ScuttleBaseVisitor {
  String m_sExpression = "";

  public LimitVisitor(FromVisitor fmFromVisitor, AssociationResolver arResolver) {
    super(fmFromVisitor, arResolver);
  }

  @Override public Void visitNumeric_value_expression(@NotNull SQLParser.Numeric_value_expressionContext ctx) {
    ValueExpressionVisitor veVisitor = new ValueExpressionVisitor(m_fmFromVisitor, m_arResolver);
    veVisitor.visit(ctx);
    m_sExpression = ExpressionUtils.formatOperand(veVisitor.toString(), false);
    return null;
  }

  public String toString() {
    return m_sExpression;
  }
}
