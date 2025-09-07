INSERT INTO
  task (
    id,
    username,
    title,
    description,
    target_date,
    done
  )
VALUES
  (
    NEXT VALUE FOR task_id_sequence,
    'admin',
    'Get Azure AI Associate Certification',
    'Get Azure AI Associate certified. This requires completing the courses and passing the exam with at least 80% score.',
    '2025-12-31',
    false
  );

INSERT INTO
  task (
    id,
    username,
    title,
    description,
    target_date,
    done
  )
VALUES
  (
    NEXT VALUE FOR task_id_sequence,
    'admin',
    'Get AWS Data Engineer Associate Certification',
    'Get AWS Data Engineer Associate certified. This requires completing the courses and passing the exam with at least 80% score.',
    '2025-12-31',
    false
  );

INSERT INTO
  task (
    id,
    username,
    title,
    description,
    target_date,
    done
  )
VALUES
  (
    NEXT VALUE FOR task_id_sequence,
    'john',
    'Get Azure DevOps Expert Certification',
    'Get Azure DevOps Expert (AZ-400) certified. This requires completing the courses and passing the exam with at least 80% score.',
    '2026-03-31',
    false
  );

INSERT INTO
  task (
    id,
    username,
    title,
    description,
    target_date,
    done
  )
VALUES
  (
    NEXT VALUE FOR task_id_sequence,
    'john',
    'Get GitHub Advanced Security Certification',
    'Get GitHub Advanced Security certified. This requires completing the courses and passing the exam with at least 80% score.',
    '2026-03-31',
    false
  );