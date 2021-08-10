package metrik.project

import metrik.project.domain.model.Build
import metrik.project.domain.model.Pipeline
import metrik.project.domain.model.PipelineType
import metrik.project.domain.model.Stage
import metrik.project.rest.vo.request.BambooPipelineRequest
import metrik.project.rest.vo.request.BambooVerificationRequest
import metrik.project.rest.vo.request.GithubActionVerificationRequest
import metrik.project.rest.vo.request.GithubActionsPipelineRequest
import metrik.project.rest.vo.request.JenkinsPipelineRequest
import metrik.project.rest.vo.request.JenkinsVerificationRequest

const val pipelineID = "pipelineId"
const val projectId = "projectId"
const val name = "pipeline"
const val username = "username"
const val credential = "credential"
const val url = "http://localhost:80"
const val userInputURL = "http://localhost:80/test_project/test_repo"

val jenkinsPipeline = Pipeline(
    id = pipelineID,
    projectId = projectId,
    name = name,
    username = username,
    credential = credential,
    url = url,
    type = PipelineType.JENKINS
)
val bambooPipeline = Pipeline(
    id = pipelineID,
    projectId = projectId,
    name = name,
    username = username,
    credential = credential,
    url = url,
    type = PipelineType.BAMBOO
)
val githubActionsPipeline = Pipeline(
    id = pipelineID,
    projectId = projectId,
    name = name,
    username = username,
    credential = credential,
    url = url,
    type = PipelineType.GITHUB_ACTIONS
)
val noopPipeline = Pipeline(
    id = pipelineID,
    projectId = projectId,
    name = name,
    username = username,
    credential = credential,
    url = url,
    type = PipelineType.NOT_SUPPORTED
)

val builds = listOf(
    Build(
        stages = listOf(
            Stage(name = "clone"), Stage(name = "build"),
            Stage(name = "zzz"), Stage(name = "amazing")
        )
    ),
    Build(
        stages = listOf(
            Stage(name = "build"), Stage("good")
        )
    )
)

fun buildJenkinsPipelineRequest() =
    JenkinsPipelineRequest(
        name = "pipeline",
        username = "username",
        credential = "credential",
        url = "url"
    )

fun buildBambooPipelineRequest() =
    BambooPipelineRequest(
        name = "pipeline",
        credential = "credential",
        url = "url"
    )

fun buildGithubActionsPipelineRequest() =
    GithubActionsPipelineRequest(
        name = "pipeline",
        credential = "credential",
        url = "url"
    )

fun buildJenkinsPipelineVerificationRequest() = JenkinsVerificationRequest(
    url = "url",
    username = "username",
    credential = "credential"
)

fun buildBambooPipelineVerificationRequest() = BambooVerificationRequest(
    url = "url",
    credential = "credential",
)

fun buildGithubActionsPipelineVerificationRequest() = GithubActionVerificationRequest(
    url = "url",
    credential = "credential",
)

fun buildPipeline(type: PipelineType = PipelineType.NOT_SUPPORTED): Pipeline =
    when (type) {
        PipelineType.JENKINS -> jenkinsPipeline.copy()
        PipelineType.BAMBOO -> bambooPipeline.copy()
        PipelineType.GITHUB_ACTIONS -> githubActionsPipeline.copy()
        else -> noopPipeline.copy()
    }
