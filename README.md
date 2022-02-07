# Error reproduction for Dokka

This project contains a simple reproduction case in which Dokka will fail to generate documentation for the java 
project because an error is thrown due to Dokka's inability to correctly parse the `String[].class` value used
in the method annotation on the `Library` class.

## Reproducing the Error

Clone/Checkout project, cd to root of project in your commandline, and execute `./gradlew dokkaHtml`

Full content of the error:

```
* What went wrong:
Execution failed for task ':lib:dokkaHtml'.
> class com.intellij.psi.PsiArrayType cannot be cast to class com.intellij.psi.impl.source.PsiClassReferenceType (com.intellij.psi.PsiArrayType and com.intellij.psi.impl.source.PsiClassReferenceType are in unnamed module of loader java.net.URLClassLoader @4b7ce49a)

* Try:
> Run with --info or --debug option to get more log output.
> Run with --scan to get full insights.

* Exception is:
org.gradle.api.tasks.TaskExecutionException: Execution failed for task ':lib:dokkaHtml'.
        at org.gradle.api.internal.tasks.execution.ExecuteActionsTaskExecuter.lambda$executeIfValid$1(ExecuteActionsTaskExecuter.java:145)
        at org.gradle.internal.Try$Failure.ifSuccessfulOrElse(Try.java:282)
        at org.gradle.api.internal.tasks.execution.ExecuteActionsTaskExecuter.executeIfValid(ExecuteActionsTaskExecuter.java:143)
        at org.gradle.api.internal.tasks.execution.ExecuteActionsTaskExecuter.execute(ExecuteActionsTaskExecuter.java:131)
        at org.gradle.api.internal.tasks.execution.CleanupStaleOutputsExecuter.execute(CleanupStaleOutputsExecuter.java:77)
        at org.gradle.api.internal.tasks.execution.FinalizePropertiesTaskExecuter.execute(FinalizePropertiesTaskExecuter.java:46)
        at org.gradle.api.internal.tasks.execution.ResolveTaskExecutionModeExecuter.execute(ResolveTaskExecutionModeExecuter.java:51)
        at org.gradle.api.internal.tasks.execution.SkipTaskWithNoActionsExecuter.execute(SkipTaskWithNoActionsExecuter.java:57)
        at org.gradle.api.internal.tasks.execution.SkipOnlyIfTaskExecuter.execute(SkipOnlyIfTaskExecuter.java:56)
        at org.gradle.api.internal.tasks.execution.CatchExceptionTaskExecuter.execute(CatchExceptionTaskExecuter.java:36)
        at org.gradle.api.internal.tasks.execution.EventFiringTaskExecuter$1.executeTask(EventFiringTaskExecuter.java:77)
        at org.gradle.api.internal.tasks.execution.EventFiringTaskExecuter$1.call(EventFiringTaskExecuter.java:55)
        at org.gradle.api.internal.tasks.execution.EventFiringTaskExecuter$1.call(EventFiringTaskExecuter.java:52)
        at org.gradle.internal.operations.DefaultBuildOperationRunner$CallableBuildOperationWorker.execute(DefaultBuildOperationRunner.java:204)
        at org.gradle.internal.operations.DefaultBuildOperationRunner$CallableBuildOperationWorker.execute(DefaultBuildOperationRunner.java:199)
        at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:66)
        at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:59)
        at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:157)
        at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:59)
        at org.gradle.internal.operations.DefaultBuildOperationRunner.call(DefaultBuildOperationRunner.java:53)
        at org.gradle.internal.operations.DefaultBuildOperationExecutor.call(DefaultBuildOperationExecutor.java:73)
        at org.gradle.api.internal.tasks.execution.EventFiringTaskExecuter.execute(EventFiringTaskExecuter.java:52)
        at org.gradle.execution.plan.LocalTaskNodeExecutor.execute(LocalTaskNodeExecutor.java:74)
        at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph$InvokeNodeExecutorsAction.execute(DefaultTaskExecutionGraph.java:402)
        at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph$InvokeNodeExecutorsAction.execute(DefaultTaskExecutionGraph.java:389)
        at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph$BuildOperationAwareExecutionAction.execute(DefaultTaskExecutionGraph.java:382)
        at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph$BuildOperationAwareExecutionAction.execute(DefaultTaskExecutionGraph.java:368)
        at org.gradle.execution.plan.DefaultPlanExecutor$ExecutorWorker.lambda$run$0(DefaultPlanExecutor.java:127)
        at org.gradle.execution.plan.DefaultPlanExecutor$ExecutorWorker.execute(DefaultPlanExecutor.java:191)
        at org.gradle.execution.plan.DefaultPlanExecutor$ExecutorWorker.executeNextNode(DefaultPlanExecutor.java:182)
        at org.gradle.execution.plan.DefaultPlanExecutor$ExecutorWorker.run(DefaultPlanExecutor.java:124)
        at org.gradle.internal.concurrent.ExecutorPolicy$CatchAndRecordFailures.onExecute(ExecutorPolicy.java:64)
        at org.gradle.internal.concurrent.ManagedExecutorImpl$1.run(ManagedExecutorImpl.java:48)
        at org.gradle.internal.concurrent.ThreadFactoryImpl$ManagedThreadRunnable.run(ThreadFactoryImpl.java:61)
Caused by: java.lang.ClassCastException: class com.intellij.psi.PsiArrayType cannot be cast to class com.intellij.psi.impl.source.PsiClassReferenceType (com.intellij.psi.PsiArrayType and com.intellij.psi.impl.source.PsiClassReferenceType are in unnamed module of loader java.net.URLClassLoader @4b7ce49a)
        at org.jetbrains.dokka.base.translators.psi.DefaultPsiToDocumentableTranslator$DokkaPsiParser.toValue(DefaultPsiToDocumentableTranslator.kt:607)
        at org.jetbrains.dokka.base.translators.psi.DefaultPsiToDocumentableTranslator$DokkaPsiParser.toValue(DefaultPsiToDocumentableTranslator.kt:604)
        at org.jetbrains.dokka.base.translators.psi.DefaultPsiToDocumentableTranslator$DokkaPsiParser.toValue(DefaultPsiToDocumentableTranslator.kt:586)
        at org.jetbrains.dokka.base.translators.psi.DefaultPsiToDocumentableTranslator$DokkaPsiParser.toAnnotation(DefaultPsiToDocumentableTranslator.kt:643)
        at org.jetbrains.dokka.base.translators.psi.DefaultPsiToDocumentableTranslator$DokkaPsiParser.toListOfAnnotations(DefaultPsiToDocumentableTranslator.kt:583)
        at org.jetbrains.dokka.base.translators.psi.DefaultPsiToDocumentableTranslator$DokkaPsiParser.parseFunction(DefaultPsiToDocumentableTranslator.kt:405)
        at org.jetbrains.dokka.base.translators.psi.DefaultPsiToDocumentableTranslator$DokkaPsiParser.parseFunction$default(DefaultPsiToDocumentableTranslator.kt:362)
        at org.jetbrains.dokka.base.translators.psi.DefaultPsiToDocumentableTranslator$DokkaPsiParser$parseClasslike$2$invokeSuspend$$inlined$with$lambda$3$1$1.invokeSuspend(parallelCollectionOperations.kt:19)
        at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
        at kotlinx.coroutines.DispatchedTask.run(DispatchedTask.kt:106)
        at kotlinx.coroutines.scheduling.CoroutineScheduler.runSafely(CoroutineScheduler.kt:571)
        at kotlinx.coroutines.scheduling.CoroutineScheduler$Worker.executeTask(CoroutineScheduler.kt:750)
        at kotlinx.coroutines.scheduling.CoroutineScheduler$Worker.runWorker(CoroutineScheduler.kt:678)
        at kotlinx.coroutines.scheduling.CoroutineScheduler$Worker.run(CoroutineScheduler.kt:665)

```
