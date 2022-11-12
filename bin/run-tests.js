#!/usr/bin/env node

import core from '@actions/core';
import path from 'path';
import cleanStack from 'clean-stack';
import { execSync } from 'child_process';

import { runTests } from '../src/index.js';

const verbose = core.getBooleanInput('verbose', { required: false });
const mountPath = core.getInput('mount_path', { required: true });
const apiHost = process.env.ACTION_API_HOST;
const projectPath = path.resolve(process.cwd(), process.env.ACTION_PROJECT_PATH || '');
const hexletToken = core.getInput('hexlet_token', { required: true });
const containerNamespace = 'hexletprograms';

const params = {
  verbose,
  mountPath,
  hexletToken,
  apiHost,
  projectPath,
  containerNamespace,
};

try {
  const output = execSync('tput cols', { shell: '/bin/bash', stdio: ['inherit'] });
  console.log(output.toString().trim());
  await runTests(params);
} catch (e) {
  core.error('The tests have failed. Examine what they have to say. Inhale deeply. Exhale. Fix the code.');
  // NOTE: бектрейс экшена пользователям не нужен
  if (!verbose) {
    e.stack = cleanStack(e.stack);
  }
  throw e;
}
