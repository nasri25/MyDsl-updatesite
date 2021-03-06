/*
 * generated by Xtext 2.19.0
 */
package org.xtext.example.mydsl.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.xtext.example.mydsl.myDsl.MyDslPackage;
import org.xtext.example.mydsl.myDsl.School;
import org.xtext.example.mydsl.myDsl.SchoolModel;
import org.xtext.example.mydsl.myDsl.Student;
import org.xtext.example.mydsl.myDsl.Teacher;
import org.xtext.example.mydsl.services.MyDslGrammarAccess;

@SuppressWarnings("all")
public class MyDslSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private MyDslGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == MyDslPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case MyDslPackage.SCHOOL:
				sequence_School(context, (School) semanticObject); 
				return; 
			case MyDslPackage.SCHOOL_MODEL:
				sequence_SchoolModel(context, (SchoolModel) semanticObject); 
				return; 
			case MyDslPackage.STUDENT:
				sequence_Student(context, (Student) semanticObject); 
				return; 
			case MyDslPackage.TEACHER:
				sequence_Teacher(context, (Teacher) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     SchoolModel returns SchoolModel
	 *
	 * Constraint:
	 *     schools+=School+
	 */
	protected void sequence_SchoolModel(ISerializationContext context, SchoolModel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     School returns School
	 *
	 * Constraint:
	 *     (name=STRING persons+=Person*)
	 */
	protected void sequence_School(ISerializationContext context, School semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Person returns Student
	 *     Student returns Student
	 *
	 * Constraint:
	 *     (name=STRING registrationNum=INT (teachers+=[Teacher|STRING] teachers+=[Teacher|STRING]*)?)
	 */
	protected void sequence_Student(ISerializationContext context, Student semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Person returns Teacher
	 *     Teacher returns Teacher
	 *
	 * Constraint:
	 *     name=STRING
	 */
	protected void sequence_Teacher(ISerializationContext context, Teacher semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MyDslPackage.Literals.PERSON__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MyDslPackage.Literals.PERSON__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTeacherAccess().getNameSTRINGTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
}
