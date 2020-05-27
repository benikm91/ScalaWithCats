lazy val exerciseSettings = Seq(
  scalaVersion := "2.13.2",
  Compile / scalaSource := baseDirectory.value / "src",
  Test / scalaSource := baseDirectory.value / "test",
  Compile / unmanagedSourceDirectories += baseDirectory.value / "src-given",
)

lazy val root = (project in file("."))
  .settings(
    name := "Scala Cats",
  )
  .aggregate(chapter1)

lazy val chapter1 = (project in file("./Chapter1"))
  .settings(
    name := "Chapter 1",
  )
  .aggregate(chapter1PrintableLibrary)
  .aggregate(chapter1CatShow)
  .aggregate(chapter1EqualityLibertyFelinity)

lazy val chapter1PrintableLibrary = (project in file("./Chapter1/PrintableLibrary"))
  .settings(
    name := "Printable Library",
    version := "0.1",
    exerciseSettings,
  )

lazy val chapter1CatShow = (project in file("./Chapter1/CatShow"))
  .settings(
    name := "Cat Show",
    version := "0.1",
    exerciseSettings,
    libraryDependencies += "org.typelevel" %% "cats-core" % "2.0.0"
  )

lazy val chapter1EqualityLibertyFelinity = (project in file("./Chapter1/EqualityLibertyFelinity"))
  .settings(
    name := "Equality, Liberty, Felinity",
    version := "0.1",
    exerciseSettings,
    libraryDependencies += "org.typelevel" %% "cats-core" % "2.0.0"
  )

lazy val chapter2 = (project in file("./Chapter2"))
  .settings(
    name := "Chapter 2",
  )
  .aggregate(chapter2TheTruthAboutMonoids)
  .aggregate(chapter2AllSetsForMonoids)
  .aggregate(chapter2AddingAllTheThings)

lazy val chapter2TheTruthAboutMonoids = (project in file("./Chapter2/TheTruthAboutMonoid"))
  .settings(
    name := "The Truth About Monoid",
    version := "0.1",
    exerciseSettings,
    libraryDependencies += "org.typelevel" %% "cats-core" % "2.0.0"
  )

lazy val chapter2AllSetsForMonoids = (project in file("./Chapter2/AllSetsForMonoids"))
  .settings(
    name := "All Sets For Monoids",
    version := "0.1",
    exerciseSettings,
    libraryDependencies += "org.typelevel" %% "cats-core" % "2.0.0"
  )

lazy val chapter2AddingAllTheThings = (project in file("./Chapter2/AddingAllTheThings"))
  .settings(
    name := "Addings All The Things",
    version := "0.1",
    exerciseSettings,
    libraryDependencies += "org.typelevel" %% "cats-core" % "2.0.0"
  )

lazy val chapter3 = (project in file("./Chapter3"))
  .settings(
    name := "Chapter 3",
  )
  .aggregate(chapter3BranchingOutWithFunctors)
  .aggregate(chapter3ShowingOffWithContramap)

lazy val chapter3BranchingOutWithFunctors = (project in file("./Chapter3/BranchingOutWithFunctors"))
  .settings(
    name := "Branching Out With Functors",
    version := "0.1",
    exerciseSettings,
    libraryDependencies += "org.typelevel" %% "cats-core" % "2.0.0"
  )

lazy val chapter3ShowingOffWithContramap = (project in file("./Chapter3/ShowingOffWithContramap"))
  .settings(
    name := "Showing Off With Contramap",
    version := "0.1",
    exerciseSettings,
    libraryDependencies += "org.typelevel" %% "cats-core" % "2.0.0"
  )

lazy val chapter4 = (project in file("./Chapter4"))
  .settings(
    name := "Chapter 4",
  )
  .aggregate(chapter4GettingFuncY)
  .aggregate(chapter4MonadicSecretIdentities)
  .aggregate(chapter4SaferFoldingUsingEval)
  .aggregate(chapter4ShowYourWorking)
  .aggregate(chapter4HackingOnReader)
  .aggregate(chapter4PostOrderCalculator)
  .aggregate(chapter4BranchOutFurtherWithMonads)

lazy val chapter4GettingFuncY = (project in file("./Chapter4/GettingFuncY"))
  .settings(
    name := "Getting Func-y",
    version := "0.1",
    exerciseSettings,
    libraryDependencies += "org.typelevel" %% "cats-core" % "2.0.0"
  )

lazy val chapter4MonadicSecretIdentities = (project in file("./Chapter4/MonadicSecretIdentities"))
  .settings(
    name := "Monadic Secret Identities",
    version := "0.1",
    exerciseSettings,
    libraryDependencies += "org.typelevel" %% "cats-core" % "2.0.0"
  )

lazy val chapter4SaferFoldingUsingEval = (project in file("./Chapter4/SaferFoldingUsingEval"))
  .settings(
    name := "Safer Folding using Eval",
    version := "0.1",
    exerciseSettings,
    libraryDependencies += "org.typelevel" %% "cats-core" % "2.0.0"
  )

lazy val chapter4ShowYourWorking = (project in file("./Chapter4/ShowYourWorking"))
  .settings(
    name := "Show Your Working",
    version := "0.1",
    exerciseSettings,
    libraryDependencies += "org.typelevel" %% "cats-core" % "2.0.0"
  )

lazy val chapter4HackingOnReader = (project in file("./Chapter4/HackingOnReader"))
  .settings(
    name := "Hacking On Reader",
    version := "0.1",
    exerciseSettings,
    libraryDependencies += "org.typelevel" %% "cats-core" % "2.0.0"
  )

lazy val chapter4PostOrderCalculator = (project in file("./Chapter4/PostOrderCalculator"))
  .settings(
    name := "Post Order Calculator",
    version := "0.1",
    exerciseSettings,
    libraryDependencies += "org.typelevel" %% "cats-core" % "2.0.0"
  )

lazy val chapter4BranchOutFurtherWithMonads = (project in file("./Chapter4/BranchOutFurtherWithMonads"))
  .settings(
    name := "Branch Out Further With Monads",
    version := "0.1",
    exerciseSettings,
    libraryDependencies += "org.typelevel" %% "cats-core" % "2.0.0"
  )

lazy val chapter5 = (project in file("./Chapter5"))
  .settings(
    name := "Chapter 5",
  )
  .aggregate(chapter5TransformAndRollOut)

lazy val chapter5TransformAndRollOut = (project in file("./Chapter5/TransformAndRollOut"))
  .settings(
    name := "Transform And Roll Out",
    version := "0.1",
    exerciseSettings,
    libraryDependencies += "org.typelevel" %% "cats-core" % "2.0.0"
  )

lazy val chapter6 = (project in file("./Chapter6"))
  .settings(
    name := "Chapter 6",
  )
  .aggregate(chapter6FormValidation)

lazy val chapter6FormValidation = (project in file("./Chapter6/FormValidation"))
  .settings(
    name := "Form Validation",
    version := "0.1",
    exerciseSettings,
    libraryDependencies += "org.typelevel" %% "cats-core" % "2.0.0"
  )

