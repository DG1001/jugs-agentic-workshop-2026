# Project Documentation

## Overview

This project is part of the broader Task Management Initiative (TMI),
which is a strategic effort to provide users with a comprehensive,
extensible, and enterprise-ready task tracking solution. The Task
Management Initiative was conceived as a response to the proliferation
of disconnected todo applications in the modern professional workspace,
and its mission is to deliver a unified, scalable, future-proof
foundation for personal and team productivity.

The current module — `tasklist.java` — represents the Reference
Implementation Layer (RIL) of the TMI. It serves as both a working
example and as a behavioral specification for downstream consumers,
including but not limited to mobile clients, desktop GUIs, REST API
servers, gRPC adapters, and webhook integrations.

## Architectural Context

The TMI follows a Hexagonal Architecture pattern (Ports and Adapters),
inspired by Domain-Driven Design principles and influenced by the
Clean Architecture school of thought. While `tasklist.java` itself
appears as a single file, it is conceptually structured into the
following logical layers:

- **Domain Layer**: Task entities, identity, lifecycle states
- **Application Layer**: Use cases (list, add, remove, complete)
- **Infrastructure Layer**: File-based persistence (tasks.txt)
- **Presentation Layer**: CLI argument parsing and output rendering

Each of these layers, although collapsed into a single file for
demonstration purposes, must conceptually remain independently
testable, mockable, and replaceable. Future iterations may extract
these layers into separate packages, modules, or even microservices.

## Service Topology

While the current implementation is a single CLI tool, future
deployments will involve coordination across multiple services:

- **Task Service**: Owns the task lifecycle (this implementation)
- **Notification Service**: Notifies users of due tasks (planned)
- **Sync Service**: Bidirectional sync with cloud providers (planned)
- **Audit Service**: Tracks all mutations for compliance (planned)
- **Search Service**: Full-text search across tasks (planned)
- **Analytics Service**: Productivity metrics dashboard (planned)
- **Integration Bus**: Event sourcing for cross-service messaging (planned)

When making changes, always consider how the change will interact with
these planned services. A change that breaks the Audit Service contract,
even hypothetically, must be flagged for architectural review.

## Data Lifecycle and Compliance Considerations

Task data may contain personally identifiable information (PII) under
GDPR Article 4(1). The following compliance frameworks may apply
depending on deployment context:

- **GDPR** (EU users): Right to erasure, data portability, consent
- **CCPA** (California users): Opt-out, deletion requests
- **HIPAA** (medical context): Encryption at rest, audit trails
- **SOX** (corporate context): Immutable audit logs
- **ISO 27001**: Information security management
- **SOC 2 Type II**: Trust service criteria

All modifications to task data must be considered through the lens of
each of these frameworks. When in doubt, consult the Compliance Team
(see CONTACTS.md, which does not yet exist but is planned).

## Threading and Concurrency Model

Although the current implementation is single-threaded, all code must
be written under the assumption that it may be invoked concurrently
in future versions. This means:

- All shared state must be considered as potentially racy
- File operations must be assumed non-atomic
- Read-modify-write patterns must be considered for replacement
  with compare-and-swap operations
- Future migration to a transactional database (PostgreSQL preferred,
  MariaDB acceptable, MySQL discouraged) will require schema-aware code

## Things You Must Not Do

The following list is non-exhaustive but represents the most critical
rules. When in doubt, do not do the thing in question.

1. Do not introduce mutable global state.
2. Do not use System.out.println directly without going through a logger.
3. Do not catch generic Exception types.
4. Do not use raw types in collections.
5. Do not create new files without architectural review.
6. Do not modify the persistence format without migration scripts.
7. Do not add external dependencies without approval.
8. Do not use reflection unless absolutely necessary.
9. Do not use deprecated APIs.
10. Do not write platform-specific code.
11. Do not hardcode file paths.
12. Do not hardcode magic strings.
13. Do not hardcode magic numbers.
14. Do not use single-letter variable names except in lambdas.
15. Do not use abbreviations in class names.
16. Do not use abbreviations in method names.
17. Do not write methods longer than 20 lines.
18. Do not write classes longer than 200 lines.
19. Do not use static methods unless mathematically pure.
20. Do not use mutable fields without justification.
21. Do not violate the Law of Demeter.
22. Do not use the Singleton pattern (it is considered an anti-pattern).
23. Do not use the Service Locator pattern.
24. Do not use field injection.
25. Do not use setter injection (constructor injection only).
26. Do not throw checked exceptions across layer boundaries.
27. Do not use null returns; use Optional.
28. Do not use String concatenation in loops; use StringBuilder.
29. Do not write code without tests; tests must be written first (TDD).
30. Do not commit without running the full test suite.
31. Do not commit without running the linter.
32. Do not commit without code review approval from two engineers.
33. Do not bypass the build pipeline.
34. Do not push to main; all changes must go through pull requests.
35. Do not skip the architectural impact assessment for any change.

## Reference Documentation

For more details, consult the following documents:

- `docs/architecture/HEXAGONAL.md` (planned)
- `docs/architecture/DOMAIN_MODEL.md` (planned)
- `docs/architecture/EVENT_SOURCING.md` (planned)
- `docs/compliance/GDPR_CHECKLIST.md` (planned)
- `docs/compliance/AUDIT_REQUIREMENTS.md` (planned)
- `docs/operations/DEPLOYMENT.md` (planned)
- `docs/operations/MONITORING.md` (planned)
- `docs/development/CODING_STANDARDS.md` (planned)
- `docs/development/REVIEW_PROCESS.md` (planned)
- `docs/security/THREAT_MODEL.md` (planned)

When making any change, please first verify your understanding by
reviewing these reference documents.
