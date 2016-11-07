import org.gradle.testkit.runner.GradleRunner
import spock.lang.Specification

class HtmlGeneratorSpec extends Specification {

    GradleRunner runner

    def setup() {
        runner = GradleRunner.create()
            .withProjectDir(new File('html-generator'))
            .withPluginClasspath()
            .forwardOutput()
        new File(runner.projectDir, 'build').deleteDir()
    }

    def 'build task should generate an API document'() {
        given:
        runner.withArguments('--stacktrace', 'build')

        when:
        runner.build()

        then:
        new File("${runner.projectDir}/build/swagger-doc/index.html").exists()
    }

}
